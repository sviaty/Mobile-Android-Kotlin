package com.example.spkc6448.preferencedata

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferencesManager = SharedPreferencesManager(this)
        sharedPreferencesManager.saveSharedPreferences(Constants.PREFS_USER, "Sviatoslav")
        val data = sharedPreferencesManager.loadSharedPreferences(Constants.PREFS_USER, SharedPreferencesManager.TypeData.STRING)
    }
}
