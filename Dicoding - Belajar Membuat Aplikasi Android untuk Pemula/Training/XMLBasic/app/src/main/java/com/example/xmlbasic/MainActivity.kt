package com.example.xmlbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi variable
        var Tanggal_Lahir = findViewById<EditText>(R.id.tgl_lahir)
        var btnKlik = findViewById<Button>(R.id.btn_klik)
        var Hasil = findViewById<TextView>(R.id.hasil_klik)

        btnKlik.setOnClickListener {
            val input = Tanggal_Lahir.text.toString()
            val hasil = when (input.toInt()) {
                in 1946..1964 -> "Baby Boomer"
                in 1965..1980 -> "X"
                in 1981..1995 -> "Millenial"
                in 1996..2010 -> "Z"
                else -> "Gak Tau Mas"
            }
            Hasil.text = "Kamu Generasi $hasil"
        }
    }
}
