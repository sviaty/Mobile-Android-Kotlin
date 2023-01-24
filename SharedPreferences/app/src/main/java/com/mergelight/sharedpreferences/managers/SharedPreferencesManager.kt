package com.mergelight.sharedpreferences.managers

import android.content.Context
import android.content.SharedPreferences
import com.mergelight.sharedpreferences.constants.Constants

class SharedPreferencesManager(context: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences(Constants.KEYS_SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    // objet dans les preferencesData
    fun saveSharedPreferences(key: String, value: Any) {
        when (value) {
            is String -> sharedPreferences?.edit()?.putString(key, value)?.apply()
            is Int -> sharedPreferences?.edit()?.putInt(key, value)?.apply()
            is Float -> sharedPreferences?.edit()?.putFloat(key, value)?.apply()
            is Boolean -> sharedPreferences?.edit()?.putBoolean(key, value)?.apply()
            else -> return
        }

    }

    fun loadSharedPreferences(key: String, type: TypeData): Any? {
        return when (type) {
            TypeData.STRING -> sharedPreferences?.getString(key, null)
            TypeData.INT -> sharedPreferences?.getInt(key, 0)
            TypeData.FLOAT -> sharedPreferences?.getFloat(key, 0.0F)
            TypeData.BOOLEAN -> sharedPreferences?.getBoolean(key, false)
        }
    }

    enum class TypeData {
        STRING, INT, FLOAT, BOOLEAN
    }
}