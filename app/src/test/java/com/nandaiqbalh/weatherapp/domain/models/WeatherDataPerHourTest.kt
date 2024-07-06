package com.nandaiqbalh.weatherapp.domain.models

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime

class WeatherDataPerHourTest {

	@Test
	fun `weather data per hour initializes correctly`() {
		// Sample values for initialization
		val time = LocalDateTime.of(2024, 7, 6, 12, 0)
		val temperature = 25.0
		val pressure = 1015.0
		val humidity = 65.0
		val weatherType = WeatherType.ClearSky // Adjust with appropriate WeatherType enum value

		// Create WeatherDataPerHour object
		val weatherDataPerHour = WeatherDataPerHour(
			time = time,
			temperatureCelsius = temperature,
			pressure = pressure,
			humidity = humidity,
			weatherType = weatherType
		)

		// Assert values
		assertEquals(time, weatherDataPerHour.time)
		assertEquals(temperature, weatherDataPerHour.temperatureCelsius, 0.01) // Optional tolerance for floating point comparison
		assertEquals(pressure, weatherDataPerHour.pressure, 0.01)
		assertEquals(humidity, weatherDataPerHour.humidity, 0.01)
		assertEquals(weatherType, weatherDataPerHour.weatherType)
	}
}
