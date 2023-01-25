package com.example.kotlin_ar_core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.ar.core.ArCoreApk

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable AR-related functionality on ARCore supported devices only.
        maybeEnableArButton()
        
        setContentView(R.layout.activity_main)
    }

    fun maybeEnableArButton() {
        val availability = ArCoreApk.getInstance().checkAvailability(this)
        if (availability.isTransient) {
            // Continue to query availability at 5Hz while compatibility is checked in the background.
            Handler().postDelayed({
                maybeEnableArButton()
            }, 200)
        }
        if (availability.isSupported) {
            //mArButton.visibility = View.VISIBLE
            //mArButton.isEnabled = true
        } else { // The device is unsupported or unknown.
            //mArButton.visibility = View.INVISIBLE
            //mArButton.isEnabled = false
        }
    }
}