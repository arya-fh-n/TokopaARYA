package com.arfdevs.phincontrainee.ui.data

import android.content.Context
import java.lang.IllegalArgumentException

class SharedPrefHelper(context: Context) {
    private val preferences = context.getSharedPreferences("tokoPhinconPrefs", Context.MODE_PRIVATE)

    fun setValue(key: String, value: Any?) {
        with(preferences.edit()) {
            when (value) {
                is String -> putString(key, value)
                is Int -> putInt(key, value)
                is Boolean -> putBoolean(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Invalid data type for SharedPreferences")
            }
            apply()
        }
    }

    fun getValue(key: String, defaultValue: Any? = null): Any? {
        with(preferences) {
            return when (defaultValue) {
                is String -> getString(key, defaultValue)
                is Int -> getInt(key, defaultValue)
                is Boolean -> getBoolean(key, defaultValue)
                is Float -> getFloat(key, defaultValue)
                is Long -> getLong(key, defaultValue)
                else -> null
            }
        }
    }



    fun resetValue(key: String) {
        preferences.edit().remove(key).apply()
    }
}