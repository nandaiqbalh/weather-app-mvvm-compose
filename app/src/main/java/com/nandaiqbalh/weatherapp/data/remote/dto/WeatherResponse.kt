package com.nandaiqbalh.weatherapp.data.remote.dto

import com.squareup.moshi.Json

data class WeatherResponse(

	@field:Json(name = "hourly")
	val weatherData: WeatherDataDto)