/**
 * Created by Joe Taveras.
 */

package com.company_name.arlo_kiosk.activity

import android.content.Intent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import com.company_name.arlo_kiosk.R
import android.view.View
import android.os.Bundle
import android.content.Context


class FridayEvents: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, FridayEvents::class.java)
		}
	}
	
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		this.setContentView(R.layout.friday_events)
		this.init()
	}
	
	private fun init() {
	
	}

	fun returnHomeFriday(view: View) {
		finish()
	}
	fun backFriday(view: View) {
		finish()
	}
}
