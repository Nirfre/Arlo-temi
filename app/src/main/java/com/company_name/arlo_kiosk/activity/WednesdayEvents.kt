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


class WednesdayEvents: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, WednesdayEvents::class.java)
		}
	}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.wednesday_events)
		this.init()
	}
	
	private fun init() {
	
	}

	fun returnHomeWednesday(view: View) {
		finish()
	}

	fun backWednesday(view: View) {
		finish()
	}
}
