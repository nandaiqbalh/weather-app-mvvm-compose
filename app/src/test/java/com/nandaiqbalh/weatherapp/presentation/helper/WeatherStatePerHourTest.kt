package com.nandaiqbalh.weatherapp.presentation.helper

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WeatherStatePerHourTest {

	@Mock
	lateinit var mockWeatherInfo: WeatherInfo

	@Test
	fun `weatherStatePerHour creation test`() {
		// Create a WeatherStatePerHour instance
		val weatherStatePerHour = WeatherStatePerHour(
			weatherInfo = mockWeatherInfo,
			isLoading = false,
			error = null
		)

		// Assert that the values are correctly set
		assertEquals(mockWeatherInfo, weatherStatePerHour.weatherInfo)
		assertEquals(false, weatherStatePerHour.isLoading)
		assertEquals(null, weatherStatePerHour.error)
	}

	@Test
	fun `weatherStatePerHour null weatherInfo test`() {
		// Create a WeatherStatePerHour instance with null weatherInfo
		val weatherStatePerHour = WeatherStatePerHour(
			weatherInfo = null,
			isLoading = true,
			error = "Test error"
		)

		// Assert that the values are correctly set
		assertEquals(null, weatherStatePerHour.weatherInfo)
		assertEquals(true, weatherStatePerHour.isLoading)
		assertEquals("Test error", weatherStatePerHour.error)
	}
}
