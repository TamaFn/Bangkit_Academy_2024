package com.example.submission1githubuser.Preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//  Menbuat Instance Datastore
//  1. Property delegation adalah sebuah mekanisme untuk mendelegasikan suatu tugas kepada class lain. Dengan menggunakan cara ini, Anda tidak perlu tahu bagaimana cara membuat DataStore secara detail
//  2. “settings” adalah string yang digunakan untuk memberi nama file DataStore
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")


class SettingPreferences private constructor(private val dataStore: DataStore<Preferences>) {

//  Membuat sebuah key unik untuk melakukan penyimpanan Data ke Preference Datastore
    private val THEME_KEY = booleanPreferencesKey("theme_setting")

//  Digunakan untuk membaca data
    fun getThemeSetting(): Flow<Boolean> {
        return dataStore.data.map { preferences ->
            preferences[THEME_KEY] ?: false
        }
    }

//  Digunakan untuk menyimpan data
    suspend fun saveThemeSetting(isDarkModeActive: Boolean) {
        dataStore.edit { preferences ->
            preferences[THEME_KEY] = isDarkModeActive
        }
    }

//  1. Perlu diketahui bahwa instance DataStore harus berupa Singleton.
//  Singleton hanya memperbolehkan ada satu instance yang digunakan di banyak tempat

//  Karena itu untuk membuat SettingPreference, kita tidak menggunakan constructor secara langsung,
//  melainkan melalui fungsi getInstance yang berfungsi sebagai Singleton
    companion object {
        @Volatile
        private var INSTANCE: SettingPreferences? = null

        fun getInstance(dataStore: DataStore<Preferences>): SettingPreferences {
            return INSTANCE ?: synchronized(this) {
                val instance = SettingPreferences(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

}