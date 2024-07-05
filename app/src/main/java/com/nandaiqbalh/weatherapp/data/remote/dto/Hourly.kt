package com.nandaiqbalh.weatherapp.data.remote.dto

data class Hourly(
    val temperature_2m: List<Double>,
    val time: List<String>,
    val weather_code: List<Int>
)