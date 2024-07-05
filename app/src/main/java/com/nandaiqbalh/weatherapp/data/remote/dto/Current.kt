package com.nandaiqbalh.weatherapp.data.remote.dto

data class Current(
    val interval: Int,
    val relative_humidity_2m: Int,
    val surface_pressure: Double,
    val temperature_2m: Double,
    val time: String,
    val weather_code: Int
)