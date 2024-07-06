package com.nandaiqbalh.weatherapp.domain.repository

import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.util.Resource
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.HttpException
import java.io.IOException

class WeatherRepositoryTest {

	@Mock
	private lateinit var mockRepository: WeatherRepository

	@Before
	fun setup() {
		MockitoAnnotations.initMocks(this)
	}

	@Test
	fun `getWeatherForecast success returns Resource Success with WeatherInfo`() = runBlocking {
		// Mock response from repository
		val lat = 12.34
		val long = 56.78
		val mockWeatherInfo = WeatherInfo(
			weatherDataPerDay = emptyMap(),
			weatherDataPerWeek = emptyMap(),
			currentWeatherData = null
		)
		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(Resource.Success(mockWeatherInfo))

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(Resource.Success(mockWeatherInfo), result)
	}

	@Test
	fun `getWeatherForecast network error returns Resource Error`() = runBlocking {
		// Mock network error from repository
		val lat = 12.34
		val long = 56.78
		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(Resource.Error("Network error", null))

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(Resource.Error("Network error", null), result)
	}

	@Test
	fun `getWeatherForecast server error returns Resource Error`() = runBlocking {
		// Mock server error from repository
		val lat = 12.34
		val long = 56.78
		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(Resource.Error("Server error", null))

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(Resource.Error("Server error", null), result)
	}

	@Test
	fun `getWeatherForecast unexpected error returns Resource Error`() = runBlocking {
		// Mock unexpected error from repository
		val lat = 12.34
		val long = 56.78
		`when`(mockRepository.getWeatherForecast(lat, long)).thenReturn(Resource.Error("Unexpected error", null))

		// Call repository method
		val result = mockRepository.getWeatherForecast(lat, long)

		// Assert result
		assertEquals(Resource.Error("Unexpected error", null), result)
	}
}
