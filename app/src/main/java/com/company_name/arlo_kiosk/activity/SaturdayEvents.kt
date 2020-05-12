/**
 * Created by Joe Taveras.
 */

package com.company_name.arlo_kiosk.activity

import android.widget.ImageView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.view.View
import com.company_name.arlo_kiosk.R
import androidx.constraintlayout.widget.ConstraintLayout


class SaturdayEvents: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, SaturdayEvents::class.java)
		}
	}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.saturday_events)
		this.init()
	}
	
	private fun init() {
	
	}

	fun returnHomeSaturday(view: View) {
		finish()
	}

	fun backSaturday(view: View) {
		finish()
	}
}
