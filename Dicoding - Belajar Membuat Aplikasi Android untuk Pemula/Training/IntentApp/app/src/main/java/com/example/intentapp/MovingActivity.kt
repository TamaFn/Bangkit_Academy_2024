package com.example.intentapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MovingActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moving)

        val btnBackHome: Button = findViewById(R.id.btn_back_home)
        btnBackHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_home -> {
                val backIntent = Intent(this@MovingActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }



}