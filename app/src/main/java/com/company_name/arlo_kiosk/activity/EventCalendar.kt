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
import android.content.Context
import com.company_name.arlo_kiosk.R
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest


class EventCalendar: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, EventCalendar::class.java)
		}
	}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.event_calendar)
		this.init()
	}
	
	private fun init() {
	
	}

	fun tuesday(view: View) {
		val intent = Intent(this, TuesdayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Tuesday", false))
		}

		startActivity(intent)
	}

	fun wednesday(view: View) {
		val intent = Intent(this, WednesdayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Wednesday", false))
		}

		startActivity(intent)
	}
	fun thursday(view: View) {
		val intent = Intent(this, ThursdayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Thursday", false))
		}

		startActivity(intent)
	}
	fun friday(view: View) {
		val intent = Intent(this, FridayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Friday", false))
		}

		startActivity(intent)
	}
	fun saturday(view: View) {
		val intent = Intent(this, SaturdayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Saturday", false))
		}

		startActivity(intent)
	}
	fun sunday(view: View) {
		val intent = Intent(this, SundayEvents::class.java).apply {
			Robot.getInstance().speak(TtsRequest.create("Here's what's going on Sunday", false))
		}

		startActivity(intent)
	}

	fun returnHomeEvents(view: View) {
		finish()
	}
}
