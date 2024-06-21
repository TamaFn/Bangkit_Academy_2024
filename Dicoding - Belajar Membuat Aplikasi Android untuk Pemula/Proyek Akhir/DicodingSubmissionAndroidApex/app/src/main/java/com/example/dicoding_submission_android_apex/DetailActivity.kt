package com.example.dicoding_submission_android_apex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            when (item.itemId) {
                R.id.about -> {
                    val goAbout = Intent(this@DetailActivity, MainActivity::class.java)
                    startActivity(goAbout)
                }
            }
            return super.onOptionsItemSelected(item)
        }

        val actionbar = supportActionBar
        actionbar!!.title = "Detail Information"


        val tvCharName: TextView = findViewById(R.id.char_name)
        val tvCharGender: TextView = findViewById(R.id.char_gender)
        val tvCharAge: TextView = findViewById(R.id.char_age)
        val tvCharHomeWorld: TextView = findViewById(R.id.char_homeworld)
        val tvCharClass: TextView = findViewById(R.id.char_class)
        val tvCharTactical: TextView = findViewById(R.id.char_tactical)
        val tvCharPassive: TextView = findViewById(R.id.char_passive)
        val tvCharUltimate: TextView = findViewById(R.id.char_ultimate)
        val tvCharTacticalDescription: TextView = findViewById(R.id.char_tactical_decs)
        val tvCharPassiveDescription: TextView = findViewById(R.id.char_passive_desc)
        val tvCharUltimateDescription: TextView = findViewById(R.id.char_ultimate_desc)
        val imgCharPictureProfile: ImageView = findViewById(R.id.char_profile)
        val imgCharPictureCover: ImageView = findViewById(R.id.char_cover)
        val imgCharIconTactical: ImageView = findViewById(R.id.icon_tactical)
        val imgCharIconPassive: ImageView = findViewById(R.id.icon_passive)
        val imgCharIconUltimate: ImageView = findViewById(R.id.icon_ultimate)
        val imgCharIconClass: ImageView = findViewById(R.id.char_icon_class)

        val charName = intent.getStringExtra(EXTRA_NAME)
        val charGender = intent.getStringExtra(EXTRA_GENDER)
        val charAge = intent.getStringExtra(EXTRA_AGE)
        val charHomeworld = intent.getStringExtra(EXTRA_HOMEWORLD)
        val charClassBattle = intent.getStringExtra(EXTRA_CLASSTYPE)
        val charTactical = intent.getStringExtra(EXTRA_TACTICALABILITY)
        val charPassive = intent.getStringExtra(EXTRA_PASSIVEABILITY)
        val charUltimate = intent.getStringExtra(EXTRA_ULTIMATEABILITY)
        val charTacticalDesc = intent.getStringExtra(EXTRA_TACTICALABILITYDESC)
        val charPassiveDesc = intent.getStringExtra(EXTRA_PASSIVEABILITYDESC)
        val charUltimateDesc = intent.getStringExtra(EXTRA_ULTIMATEABILITYDESC)
        val charPictureProfile = intent.getIntExtra(EXTRA_PHOTOPROFILE, 0)
        val charPictureCover = intent.getIntExtra(EXTRA_PHOTOCOVER, 0)
        val charIconTactical = intent.getIntExtra(EXTRA_ICONTACTICAL, 0)
        val charIconPassive = intent.getIntExtra(EXTRA_ICONPASSIVE, 0)
        val charIconUltimate = intent.getIntExtra(EXTRA_ICONULTIMATE, 0)
        val charIconClass = intent.getIntExtra(EXTRA_ICONCLASS, 0)

        tvCharName.text = charName
        tvCharGender.text = charGender
        tvCharAge.text = charAge
        tvCharHomeWorld.text = charHomeworld
        tvCharClass.text = charClassBattle
        tvCharTactical.text = charTactical
        tvCharPassive.text = charPassive
        tvCharUltimate.text = charUltimate
        tvCharTacticalDescription.text = charTacticalDesc
        tvCharPassiveDescription.text = charPassiveDesc
        tvCharUltimateDescription.text = charUltimateDesc
        Glide.with(this)
            .load(charPictureProfile)
            .apply(RequestOptions())
            .into(imgCharPictureProfile)
        Glide.with(this)
            .load(charPictureCover)
            .apply(RequestOptions())
            .into(imgCharPictureCover)
        Glide.with(this)
            .load(charIconTactical)
            .apply(RequestOptions())
            .into(imgCharIconTactical)
        Glide.with(this)
            .load(charIconPassive)
            .apply(RequestOptions())
            .into(imgCharIconPassive)
        Glide.with(this)
            .load(charIconUltimate)
            .apply(RequestOptions())
            .into(imgCharIconUltimate)
        Glide.with(this)
            .load(charIconClass)
            .apply(RequestOptions())
            .into(imgCharIconClass)

    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_GENDER = "extra_gender"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_HOMEWORLD = "extra_homeworld"
        const val EXTRA_CLASSTYPE = "extra_class"
        const val EXTRA_TACTICALABILITY = "extra_tactical"
        const val EXTRA_PASSIVEABILITY = "extra_passive"
        const val EXTRA_ULTIMATEABILITY = "extra_ultimate"
        const val EXTRA_TACTICALABILITYDESC = "extra_tactical_desc"
        const val EXTRA_PASSIVEABILITYDESC = "extra_passive_desc"
        const val EXTRA_ULTIMATEABILITYDESC = "extra_ultimate_desc"
        const val EXTRA_PHOTOPROFILE = "extra_photoprofile"
        const val EXTRA_PHOTOCOVER = "extra_photocover"
        const val EXTRA_ICONTACTICAL = "extra_icontactical"
        const val EXTRA_ICONPASSIVE = "extra_iconpassive"
        const val EXTRA_ICONULTIMATE = "extra_iconultimate"
        const val EXTRA_ICONCLASS = "extra_iconclass"
    }
}

