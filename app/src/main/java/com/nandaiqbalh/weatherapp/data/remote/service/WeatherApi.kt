package com.nandaiqbalh.weatherapp.data.remote.service

import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

	@GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
	suspend fun getWeatherForecast(
		@Query("latitude") lat: Double,
		@Query("longitude") long: Double,
	): WeatherResponse
}