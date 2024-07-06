package com.nandaiqbalh.weatherapp.domain.models

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<WeatherDataPerHour>>,
    val weatherDataPerWeek: Map<Int, List<WeatherDataPerWeek>>,
    val currentWeatherData: WeatherDataPerHour?
)
