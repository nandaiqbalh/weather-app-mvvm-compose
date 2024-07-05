package com.nandaiqbalh.weatherapp.domain.models

import java.time.LocalDate

data class WeatherInfo(
    val weatherDataPerDay: Map<LocalDate, List<WeatherData>>,
    val hourlyWeatherData: Map<LocalDate, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
