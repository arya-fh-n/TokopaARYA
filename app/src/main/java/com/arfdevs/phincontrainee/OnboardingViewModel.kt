package com.arfdevs.phincontrainee

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {

    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int>
        get() = _index

    fun setIndex(index: Int) {
        _index.value = index
        Log.d("OBVM:", this.index.value.toString())
    }
}