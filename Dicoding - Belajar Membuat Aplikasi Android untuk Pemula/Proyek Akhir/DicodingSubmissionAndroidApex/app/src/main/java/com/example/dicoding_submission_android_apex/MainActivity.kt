package com.example.dicoding_submission_android_apex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvApex: RecyclerView
    private var list: ArrayList<ApexChar> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title = "Apex Legend"

        rvApex = findViewById(R.id.rv_apex)
        rvApex.setHasFixedSize(true)

        list.addAll(ApexData.listData)
        rvApex.layoutManager = LinearLayoutManager(this)

        val listCharAdapter = ApexAdapter(list)
        rvApex.adapter = listCharAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val goAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(goAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }




}