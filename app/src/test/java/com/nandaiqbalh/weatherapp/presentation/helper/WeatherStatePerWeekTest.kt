package com.nandaiqbalh.weatherapp.presentation.helper

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class WeatherStatePerWeekTest {

	@Mock
	lateinit var mockWeatherInfo: WeatherInfo

	@Test
	fun `weatherStatePerWeek creation test`() {
		// Create a WeatherStatePerWeek instance
		val weatherStatePerWeek = WeatherStatePerWeek(
			weatherInfo = mockWeatherInfo,
			isLoading = false,
			error = null
		)

		// Assert that the values are correctly set
		assertEquals(mockWeatherInfo, weatherStatePerWeek.weatherInfo)
		assertEquals(false, weatherStatePerWeek.isLoading)
		assertEquals(null, weatherStatePerWeek.error)
	}

	@Test
	fun `weatherStatePerWeek null weatherInfo test`() {
		// Create a WeatherStatePerWeek instance with null weatherInfo
		val weatherStatePerWeek = WeatherStatePerWeek(
			weatherInfo = null,
			isLoading = true,
			error = "Test error"
		)

		// Assert that the values are correctly set
		assertEquals(null, weatherStatePerWeek.weatherInfo)
		assertEquals(true, weatherStatePerWeek.isLoading)
		assertEquals("Test error", weatherStatePerWeek.error)
	}
}
