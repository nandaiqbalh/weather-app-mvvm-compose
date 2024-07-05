package com.nandaiqbalh.weatherapp.data.remote.service

import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

	@GET("v1/forecast?current=temperature_2m,relative_humidity_2m,weather_code,surface_pressure&hourly=temperature_2m,weather_code&daily=weather_code,temperature_2m_max,temperature_2m_min&timezone=Asia%2FBangkok")
	suspend fun getWeatherForecast(
		@Query("latitude") lat: Double,
		@Query("longitude") long: Double,
	): WeatherResponse
}