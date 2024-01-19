package com.arfdevs.phincontrainee.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val _isDarkMode = MutableLiveData<Boolean>()

    val isDarkMode: LiveData<Boolean> get() = _isDarkMode

    fun setDarkMode(isEnabled: Boolean) {
        _isDarkMode.value = isEnabled
        Log.d("Theme VM:", isEnabled.toString())
    }
}