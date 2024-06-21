package com.example.submission1githubuser.ui.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.example.submission1githubuser.R
import com.example.submission1githubuser.Preferences.SettingPreferences
import com.example.submission1githubuser.Preferences.dataStore
import com.example.submission1githubuser.databinding.ActivityDarkThemeBinding
import com.example.submission1githubuser.model.DarkThemeViewModel


class DarkThemeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDarkThemeBinding
    private lateinit var darkThemeViewModel: DarkThemeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDarkThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = resources.getString(R.string.setting)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//
        val pref = SettingPreferences.getInstance(dataStore)

//      Menghubungkan DarkThemeViewModel dengan Perantara ViewModelProvider
        darkThemeViewModel = ViewModelProvider(
            this,
            DarkThemeViewModel.DarkThemeViewModelFactory(pref)
        )[DarkThemeViewModel::class.java]

        darkThemeViewModel.getThemeSettings().observe(this) { isActive ->
            updateCheckIndicator(isActive)
            if (isActive) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switchbutton.isChecked = true
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switchbutton.isChecked = false
            }
        }

        binding.switchbutton.setOnCheckedChangeListener { _: CompoundButton?, isChecked ->
            darkThemeViewModel.saveThemeSetting(isChecked)
            updateCheckIndicator(isChecked)
        }
    }


    private fun updateCheckIndicator(isChecked: Boolean) {
        binding.CheckIndicator.text = if (isChecked) resources.getString(R.string.OnMode) else resources.getString(R.string.OffMode)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

