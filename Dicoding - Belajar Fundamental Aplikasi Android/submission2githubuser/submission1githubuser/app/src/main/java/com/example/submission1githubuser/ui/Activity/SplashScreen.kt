package com.example.submission1githubuser.ui.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import com.example.submission1githubuser.R
import com.example.submission1githubuser.ui.MainActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Menyembunyikan Action Bar
        supportActionBar?.hide()

//
        val progressBar: ProgressBar = findViewById(R.id.progressBarsplash)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            progressBar.visibility = ProgressBar.VISIBLE
            startActivity(intent)
            finish()
        }, 2000)
    }
}