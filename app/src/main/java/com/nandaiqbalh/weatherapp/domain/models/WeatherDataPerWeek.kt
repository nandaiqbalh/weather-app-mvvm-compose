package com.nandaiqbalh.weatherapp.domain.models

import java.time.LocalDateTime

data class WeatherDataPerWeek(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
