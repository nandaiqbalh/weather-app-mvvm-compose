package com.nandaiqbalh.weatherapp.presentation.helper

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo

data class WeatherStatePerWeek(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
