package com.nandaiqbalh.weatherapp.data.remote.dto

data class WeatherResponse(
    val current: WeatherDataDto,
    val current_units: CurrentUnits,
    val daily: WeatherDataDto,
    val daily_units: DailyUnits,
    val elevation: Double,
    val generationtime_ms: Double,
    val hourly: WeatherDataDto,
    val hourly_units: HourlyUnits,
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezone_abbreviation: String,
    val utc_offset_seconds: Int
)