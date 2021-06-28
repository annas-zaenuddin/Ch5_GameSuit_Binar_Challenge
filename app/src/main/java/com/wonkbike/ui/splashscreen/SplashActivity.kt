package com.wonkbike.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.wonkbike.ch5_gamesuit.R
import com.wonkbike.ui.landing.LandingActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this , LandingActivity::class.java))
            finish()
        } , 1000)
    }
}