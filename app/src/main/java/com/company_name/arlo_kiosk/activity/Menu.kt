/**
 * Created by Joe Taveras.
 */

package com.company_name.arlo_kiosk.activity

import android.Manifest
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.animation.PathInterpolatorCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.company_name.arlo_kiosk.R
import com.company_name.arlo_kiosk.actions.*
import com.company_name.arlo_kiosk.adapter.SlidePagerAdapter
import com.company_name.arlo_kiosk.explanation
import com.company_name.arlo_kiosk.fragments.PageFragment1
import com.company_name.arlo_kiosk.fragments.PageFragment2
import com.company_name.arlo_kiosk.fragments.PageFragment3
import com.robotemi.sdk.Robot
import java.util.*
import kotlin.collections.ArrayList

private val REQUEST_PERMISSION_CODE = 1
private val PERMISSIONS = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)


class Menu : AppCompatActivity() {

    lateinit var pager:ViewPager
    lateinit var pagerAdapter:PagerAdapter
    var actionNumber = 1
    val robot = Robot.getInstance()
    private lateinit var beerImageView: ImageView

    companion object {
        fun newIntent(context: Context): Intent {
            // Fill the created intent with the data you want to be passed to this Activity when it's opened.
            return Intent(context, Menu::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.menu)
        this.init()
        verifyStoragePermissions(this)
        val list:ArrayList<Fragment> = ArrayList()
        list.add(PageFragment1())
        list.add(PageFragment2())
        list.add(PageFragment3())

        pager = findViewById(R.id.pager)
        pagerAdapter = SlidePagerAdapter(supportFragmentManager, list)

        pager.adapter = pagerAdapter
        val timer = Timer()
        timer.scheduleAtFixedRate(MyTimer(), 15000, 15000)

       startExplanation()

    }

    private fun init() {
        beerImageView = this.findViewById(R.id.beer_image_view)
    }

    fun eventCalendar(view: View) {
        val intent = Intent(this, EventCalendar::class.java).apply {
        }
        startActivity(intent)
    }

    fun aboutArlo(view: View) {
        val intent = Intent(this, AboutArlo::class.java).apply {
        }
        startActivity(intent)
    }

    fun verifyStoragePermissions(activity: Activity) {
        // Check if we have write permission
        val writePermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val readPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
        val recordPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.RECORD_AUDIO)
        val cameraPermission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
        if (writePermission != PackageManager.PERMISSION_GRANTED || readPermission != PackageManager.PERMISSION_GRANTED
                || cameraPermission != PackageManager.PERMISSION_GRANTED || recordPermission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(activity, PERMISSIONS, REQUEST_PERMISSION_CODE)
        }
    }

    fun startAnimationOne() {

        val animator1 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, 0f, -200f))
        animator1.duration = 1000
        animator1.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet1 = AnimatorSet()
        animatorSet1.playTogether(animator1)
        animatorSet1.setTarget(beerImageView)

        val animatorSet2 = AnimatorSet()
        animatorSet2.playTogether(animatorSet1)
        animatorSet2.start()
    }

    fun startAnimationTwo() {

        val animator2 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -200f, -400f))
        animator2.duration = 1000
        animator2.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet2 = AnimatorSet()
        animatorSet2.playTogether(animator2)
        animatorSet2.setTarget(beerImageView)

        val animatorSet3 = AnimatorSet()
        animatorSet3.playTogether(animatorSet2)
        animatorSet3.start()
    }

    fun startAnimationThree() {

        val animator3 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -400f, -600f))
        animator3.duration = 1000
        animator3.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet3 = AnimatorSet()
        animatorSet3.playTogether(animator3)
        animatorSet3.setTarget(beerImageView)

        val animatorSet4 = AnimatorSet()
        animatorSet4.playTogether(animatorSet3)
        animatorSet4.start()
    }

    fun startAnimationFour() {

        val animator4 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -600f, -800f))
        animator4.duration = 1000
        animator4.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet4 = AnimatorSet()
        animatorSet4.playTogether(animator4)
        animatorSet4.setTarget(beerImageView)

        val animatorSet5 = AnimatorSet()
        animatorSet5.playTogether(animatorSet4)
        animatorSet5.start()
    }

    fun startAnimationFive() {

        val animator5 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -800f, -960f))
        animator5.duration = 1000
        animator5.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet5 = AnimatorSet()
        animatorSet5.playTogether(animator5)
        animatorSet5.setTarget(beerImageView)

        val animatorSet6 = AnimatorSet()
        animatorSet6.playTogether(animatorSet5)
        animatorSet6.start()
    }

    fun startAnimationSix() {

        val animator6 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -960f, -1000f))
        animator6.duration = 1000
        animator6.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet6 = AnimatorSet()
        animatorSet6.playTogether(animator6)
        animatorSet6.setTarget(beerImageView)

        val animatorSet7 = AnimatorSet()
        animatorSet7.playTogether(animatorSet6)
        animatorSet7.start()

        val minute: Long = 1000 * 1 // 1000 milliseconds = 1 second

        // 1 minute
        val millisInFuture: Long = (minute)

        // Count down interval 1 second
        val countDownInterval: Long = 1000

        resetTimer(millisInFuture, countDownInterval).start()
    }

    fun resetMeter() {

        val animator7 = ObjectAnimator.ofPropertyValuesHolder(beerImageView, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -1000f, 0f))
        animator7.duration = 3000
        animator7.interpolator = PathInterpolatorCompat.create(0.42f, 0f, 0.58f, 1f)

        val animatorSet7 = AnimatorSet()
        animatorSet7.playTogether(animator7)
        animatorSet7.setTarget(beerImageView)

        val animatorSet8 = AnimatorSet()
        animatorSet8.playTogether(animatorSet7)
        animatorSet8.start()


    }

    private fun resetTimer(millisInFuture: Long, countDownInterval: Long): CountDownTimer {
        return object : CountDownTimer(millisInFuture, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                resetMeter()

            }
        }

    }

    fun beginAction(view: View) {
        when (actionNumber) {
            1 -> {
                var drinkPlayer = MediaPlayer.create(this, R.raw.gulping_sound_for_pour_up)
                startAnimationOne()
                drinkPlayer.start()
                drinkPlayer.setOnCompletionListener {
                    robot.toggleNavigationBillboard(true)
                    PickupLines(robot)
                    actionNumber++
                }
            }
            2 -> {
                var drinkPlayer = MediaPlayer.create(this, R.raw.gulping_sound_for_pour_up)
                startAnimationTwo()
                drinkPlayer.start()
                drinkPlayer.setOnCompletionListener {
                    DrunkPhotographer(this@Menu, robot)
                    actionNumber++
                }
            }
            3 -> {
                var drinkPlayer = MediaPlayer.create(this, R.raw.gulping_sound_for_pour_up)
                startAnimationThree()
                drinkPlayer.start()
                drinkPlayer.setOnCompletionListener {
                    Prankster(this@Menu, robot)
                    actionNumber++
                }
            }
            4 -> {
                var drinkPlayer = MediaPlayer.create(this, R.raw.gulping_sound_for_pour_up)
                startAnimationFour()
                drinkPlayer.start()
                drinkPlayer.setOnCompletionListener {
                    DancingRobot(this@Menu, robot)
                    actionNumber++
                }
            }
            5 -> {
                var drinkPlayer = MediaPlayer.create(this, R.raw.gulping_sound_for_pour_up)
                startAnimationFive()
                drinkPlayer.start()
                drinkPlayer.setOnCompletionListener {
                    Escape(robot)
                    actionNumber++
                }
            }
            6 -> {
                startAnimationSix()
                    ThrowUp(this@Menu, robot)
                    actionNumber = 1
            }
        }
        view.visibility = View.INVISIBLE
        Handler().postDelayed(Runnable {
            view.visibility = View.VISIBLE
        }, 5000)
    }

    inner class MyTimer : TimerTask() {
        override fun run() {
            this@Menu.runOnUiThread {
                if (pager!!.currentItem == 0) {
                    pager!!.currentItem = 1
                } else if (pager!!.currentItem == 1) {
                    pager!!.currentItem = 2

                } else {
                    pager!!.currentItem = 0

                }
            }
        }
    }


    fun startExplanation() {
        Handler().postDelayed({
            robot.hideTopBar()
            val intent = Intent(this, explanation::class.java).apply {
            }
            startActivity(intent)
        }, 100)
    }
}

