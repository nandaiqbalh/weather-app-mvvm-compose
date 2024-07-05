package com.nandaiqbalh.weatherapp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

	private val _splashCondition = mutableStateOf(true)
	val splashCondition: State<Boolean> = _splashCondition

	init {
		viewModelScope.launch {
			delay(2000)
			_splashCondition.value = false
		}
	}
}