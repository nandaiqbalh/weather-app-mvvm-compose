package com.nandaiqbalh.weatherapp.domain.models

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class WeatherDataPerWeekTest {

	@Test
	fun `weather data per week initializes correctly`() {
		// Sample values for initialization
		val time = LocalDateTime.of(2024, 7, 6, 12, 0)
		val temperature = 25.0
		val pressure = 1015.0
		val humidity = 65.0
		val weatherType = WeatherType.ClearSky // Adjust with appropriate WeatherType enum value

		// Create WeatherDataPerWeek object
		val weatherDataPerWeek = WeatherDataPerWeek(
			time = time,
			temperatureCelsius = temperature,
			pressure = pressure,
			humidity = humidity,
			weatherType = weatherType
		)

		// Assert values
		assertEquals(time, weatherDataPerWeek.time)
		assertEquals(temperature, weatherDataPerWeek.temperatureCelsius, 0.01) // Optional tolerance for floating point comparison
		assertEquals(pressure, weatherDataPerWeek.pressure, 0.01)
		assertEquals(humidity, weatherDataPerWeek.humidity, 0.01)
		assertEquals(weatherType, weatherDataPerWeek.weatherType)
	}
}
