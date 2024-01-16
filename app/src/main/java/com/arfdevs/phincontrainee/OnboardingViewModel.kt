package com.arfdevs.phincontrainee

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {

    private val index = MutableLiveData<Int>()

    fun setIndex(index: Int) {
        this.index.value = index
    }
}