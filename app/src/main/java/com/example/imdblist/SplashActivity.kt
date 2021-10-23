package com.example.imdblist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            navigateTo()
        }, 3000)

    }

    private fun navigateTo() {
        startActivity(Intent(this, MainActivity::class.java))
    }

}