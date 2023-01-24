package com.mergelight.sharedpreferences.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mergelight.sharedpreferences.R
import com.mergelight.sharedpreferences.managers.SharedPreferencesManager
import com.mergelight.sharedpreferences.constants.Constants


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferencesManager = SharedPreferencesManager(this)
        sharedPreferencesManager.saveSharedPreferences(Constants.KEYS_DATA_SHARED_PREFERENCES, "test save datas in shared preferences")
        val data: String? = sharedPreferencesManager.loadSharedPreferences(Constants.KEYS_DATA_SHARED_PREFERENCES,
            SharedPreferencesManager.TypeData.STRING
        ) as String
        Toast.makeText(applicationContext, data , Toast.LENGTH_SHORT).show()

        if (savedInstanceState != null) {
            val dataSaved = savedInstanceState.getString(Constants.KEYS_DATA_BUNDLE)
            Toast.makeText(applicationContext, dataSaved , Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.KEYS_DATA_BUNDLE, "test save datas in onSaveInstanceState")
    }

}