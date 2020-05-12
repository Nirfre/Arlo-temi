/**
 * Created by Joe Taveras.
 */

package com.company_name.arlo_kiosk.activity

import androidx.constraintlayout.widget.ConstraintLayout
import android.view.View
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.company_name.arlo_kiosk.R
import android.content.Context
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class AboutArlo: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, AboutArlo::class.java)
		}
	}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.about_arlo)
	}

	fun returnHome(view: View) {
		finish()
	}
}
