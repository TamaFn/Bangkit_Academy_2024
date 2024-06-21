package com.example.intentapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject:TextView = findViewById(R.id.tv_object_received)

        val btnBackHome3: Button = findViewById(R.id.btn_back_home_parcel)
        btnBackHome3.setOnClickListener(this)

        val person = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

//          Bila menggunakan arrayList (Ini hanya contoh saja)
//            intent.getParcelableArrayListExtra(EXTRA_PERSON, Person::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }
        if (person != null) {
            val text = "Name : ${person.name.toString()},\nEmail : ${person.email},\nAge : ${person.age},\nLocation : ${person.city}"
            tvObject.text = text
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_home_parcel -> {
                val backIntent = Intent(this@MoveWithObjectActivity, MainActivity::class.java)
                startActivity(backIntent)
            }
        }
    }

}