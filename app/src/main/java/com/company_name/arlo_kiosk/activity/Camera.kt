@file:Suppress("DEPRECATION")

package com.company_name.arlo_kiosk.activity

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.util.Log
import android.view.View
import com.company_name.arlo_kiosk.R
import com.company_name.arlo_kiosk.domain.UploadToImgurTask
import com.otaliastudios.cameraview.CameraListener
import com.otaliastudios.cameraview.PictureResult
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest
import kotlinx.android.synthetic.main.camera.*
import java.io.File
import java.io.FileOutputStream

const val CAMERA_ALBUM_NAME = "ArloPictures"

class Camera : AppCompatActivity() {

    val robot = Robot.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camera)
        camera.setLifecycleOwner(this)
        camera.toggleFacing()
        addTakePictureListener()
        robot.speak(TtsRequest.create("Free photos free photos, who wants a free photo", true))
        Handler().postDelayed({
            robot.speak(TtsRequest.create("I got some instagramming to do!", true))
            Handler().postDelayed({
                robot.tiltAngle(20)
                Robot.getInstance().speak(TtsRequest.create("Taking a picture in 4, 3, 2, 1", false))
                Handler().postDelayed({
                    camera.takePicture()
                }, 4000)
            }, 2000)
        }, 9000)
    }

    private fun addTakePictureListener() {
        camera.addCameraListener(object : CameraListener() {
            override fun onPictureTaken(result: PictureResult) {
                ivBlackSquare.visibility = View.VISIBLE
                val filePath = savePhotoAndReturnPath(result.data)
                val imgBitmap = BitmapFactory.decodeFile(filePath)
                ivCapturedPicture.setImageBitmap(imgBitmap)
                ivCapturedPicture.visibility = View.VISIBLE
                UploadToImgurTask(this@Camera).execute(filePath)
            }
        })
    }

    private fun savePhotoAndReturnPath(byteArray: ByteArray): String {
        val photoDirectory = getPublicStorageDir()
        val photoName = "ArloLogo.jpg"
        val photoFile = File(photoDirectory, photoName)
        val outputStream = FileOutputStream(photoFile.path)
        outputStream.write(byteArray)
        outputStream.close()
        return photoFile.path
    }

    private fun getPublicStorageDir(): File {
        val directory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), CAMERA_ALBUM_NAME)
        if (!directory.mkdirs()) {
            Log.d("MainActivity", "Camera directory not created")
        }
        return directory
    }
}
