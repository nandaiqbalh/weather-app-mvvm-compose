package com.nandaiqbalh.weatherapp.data.remote.service

import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherDataDto
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@Suppress("DEPRECATION")
class WeatherApiTest {

	@Mock
	private lateinit var mockWeatherApi: WeatherApi

	@Before
	fun setup() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun `getWeatherForecast returns correct WeatherResponse`() = runBlocking {
		// Mock response data
		val lat = 12.34
		val long = 56.78
		val mockWeatherDataDto = WeatherDataDto(
			time = emptyList(),
			temperatures = emptyList(),
			weatherCodes = emptyList(),
			pressures = emptyList(),
			humidities = emptyList()
		)
		val expectedResponse = WeatherResponse(mockWeatherDataDto)

		// Mock API response
		`when`(mockWeatherApi.getWeatherForecast(lat, long)).thenReturn(expectedResponse)

		// Call the API method
		val actualResponse = mockWeatherApi.getWeatherForecast(lat, long)

		// Assert the result
		assertEquals(expectedResponse, actualResponse)
	}
}
