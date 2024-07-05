package com.nandaiqbalh.weatherapp.domain.repository

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.util.Resource


interface WeatherRepository {
    suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherInfo>
}