package com.nandaiqbalh.weatherapp.domain.repository

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.util.Resource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class WeatherRepositoryTest {

	@Mock
	private lateinit var mockRepository: WeatherRepository

	@Before
	fun setup() {
		MockitoAnnotations.openMocks(this)
	}

	@Test
	fun `getWeatherForecast success returns Resource Success with WeatherInfo`() = runTest {
		// Mock response from repository
		val lat = 12.34
		val long = 56.78
		val mockWeatherInfo = WeatherInfo(
			weatherDataPerDay = emptyMap(),
			weatherDataPerWeek = emptyMap(),
			currentWeatherData = null
		)
		val expectedResource = Resource.Success(mockWeatherInfo)

		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(expectedResource)

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(expectedResource, result)
	}

	@Test
	fun `getWeatherForecast network error returns Resource Error`() = runTest {
		// Mock network error from repository
		val lat = 12.34
		val long = 56.78
		val errorMessage =
			"There was a problem with your network connection. Please check your internet connection and try again."
		val expectedResource = Resource.Error<WeatherInfo>(errorMessage, null)

		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(expectedResource)

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(expectedResource, result)
	}

	@Test
	fun `getWeatherForecast server error returns Resource Error`() = runTest {
		// Mock server error from repository
		val lat = 12.34
		val long = 56.78
		val errorMessage = "There was an unexpected server error. Please try again later."
		val expectedResource = Resource.Error<WeatherInfo>(errorMessage, null)

		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(expectedResource)

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(expectedResource, result)
	}

	@Test
	fun `getWeatherForecast unexpected error returns Resource Error`() = runTest {
		// Mock unexpected error from repository
		val lat = 12.34
		val long = 56.78
		val errorMessage = "An unexpected error occurred. Please try again later."
		val expectedResource = Resource.Error<WeatherInfo>(errorMessage, null)

		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(expectedResource)

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(expectedResource, result)
	}
}