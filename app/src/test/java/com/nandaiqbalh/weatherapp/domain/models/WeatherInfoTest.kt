package com.nandaiqbalh.weatherapp.domain.models

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDateTime

class WeatherInfoTest {

	private fun createSampleWeatherDataPerHour(): WeatherDataPerHour {
		return WeatherDataPerHour(
			time = LocalDateTime.of(2023, 7, 6, 12, 0),
			temperatureCelsius = 25.0,
			pressure = 1013.0,
			humidity = 60.0,
			weatherType = WeatherType.ClearSky
		)
	}

	@Test
	fun testWeatherInfoCreation() {
		val hourlyData = createSampleWeatherDataPerHour()
		val dailyData = WeatherDataPerWeek(
			time = LocalDateTime.of(2023, 7, 6, 12, 0),
			temperatureCelsius = 25.0,
			pressure = 1013.0,
			humidity = 60.0,
			weatherType = WeatherType.ClearSky
		)

		val weatherDataPerDay = mapOf(1 to listOf(hourlyData))
		val weatherDataPerWeek = mapOf(1 to listOf(dailyData))

		val weatherInfo = WeatherInfo(
			weatherDataPerDay = weatherDataPerDay,
			weatherDataPerWeek = weatherDataPerWeek,
			currentWeatherData = hourlyData
		)

		assertNotNull(weatherInfo)
		assertEquals(weatherDataPerDay, weatherInfo.weatherDataPerDay)
		assertEquals(weatherDataPerWeek, weatherInfo.weatherDataPerWeek)
		assertEquals(hourlyData, weatherInfo.currentWeatherData)
	}

	@Test
	fun testWeatherInfoNullCurrentWeatherData() {
		val hourlyData = createSampleWeatherDataPerHour()
		val dailyData = WeatherDataPerWeek(
			time = LocalDateTime.of(2023, 7, 6, 12, 0),
			temperatureCelsius = 25.0,
			pressure = 1013.0,
			humidity = 60.0,
			weatherType = WeatherType.ClearSky
		)

		val weatherDataPerDay = mapOf(1 to listOf(hourlyData))
		val weatherDataPerWeek = mapOf(1 to listOf(dailyData))

		val weatherInfo = WeatherInfo(
			weatherDataPerDay = weatherDataPerDay,
			weatherDataPerWeek = weatherDataPerWeek,
			currentWeatherData = null
		)

		assertNotNull(weatherInfo)
		assertEquals(weatherDataPerDay, weatherInfo.weatherDataPerDay)
		assertEquals(weatherDataPerWeek, weatherInfo.weatherDataPerWeek)
		assertNull(weatherInfo.currentWeatherData)
	}
}
