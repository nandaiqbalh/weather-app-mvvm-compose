package com.nandaiqbalh.weatherapp.data.remote.dto

data class CurrentUnits(
    val interval: String,
    val relative_humidity_2m: String,
    val surface_pressure: String,
    val temperature_2m: String,
    val time: String,
    val weather_code: String
)