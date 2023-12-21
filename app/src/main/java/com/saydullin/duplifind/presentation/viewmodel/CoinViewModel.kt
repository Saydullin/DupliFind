package com.saydullin.duplifind.presentation.viewmodel

import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinViewModel @Inject constructor(

): ViewModel() {

    private val _coin = mutableIntStateOf(0)
    val coin = _coin

    fun getCoinsDB() {
        viewModelScope.launch(Dispatchers.IO) {

        }
    }

}


