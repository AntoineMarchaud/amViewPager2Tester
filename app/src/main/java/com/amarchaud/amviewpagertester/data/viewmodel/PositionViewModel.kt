package com.amarchaud.amviewpagertester.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Object to share between Activity and Fragment
 */
class PositionViewModel : ViewModel() {
    private val _index = MutableLiveData<Int>()
    val index: LiveData<Int>
        get() = _index

    fun setIndex(position: Int) {
        _index.value = position
    }
}