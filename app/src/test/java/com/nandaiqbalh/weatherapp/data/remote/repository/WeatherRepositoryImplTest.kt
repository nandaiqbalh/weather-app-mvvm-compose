package com.nandaiqbalh.weatherapp.data.remote.repository

import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import com.nandaiqbalh.weatherapp.data.remote.service.WeatherApi
import com.nandaiqbalh.weatherapp.domain.repository.WeatherRepository
import com.nandaiqbalh.weatherapp.domain.util.Resource
import kotlinx.coroutines.runBlocking
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.HttpException
import retrofit2.Response

class WeatherRepositoryImplTest {

	private lateinit var api: WeatherApi
	private lateinit var repository: WeatherRepository

	@Before
	fun setUp() {
		api = mock(WeatherApi::class.java)
		repository = WeatherRepositoryImpl(api)
	}

	@Test
	fun `getWeatherForecast returns network error`() = runBlocking {
		// Given
		`when`(api.getWeatherForecast(0.0, 0.0)).thenThrow(RuntimeException("Network error"))

		// When
		val result = repository.getWeatherForecast(0.0, 0.0)

		// Then
		assertTrue(result is Resource.Error)
		assertEquals("An unexpected error occurred. Please try again later.", result.message)
	}

	@Test
	fun `getWeatherForecast returns HTTP error`() = runBlocking {
		// Given
		val responseBody =
			"{\"key\":[\"somestuff\"]}".toResponseBody("application/json".toMediaTypeOrNull())
		val response = Response.error<WeatherResponse>(500, responseBody)
		val httpException = HttpException(response)
		`when`(api.getWeatherForecast(0.0, 0.0)).thenThrow(httpException)

		// When
		val result = repository.getWeatherForecast(0.0, 0.0)

		// Then
		assertTrue(result is Resource.Error)
		assertEquals("There was an unexpected server error. Please try again later.", result.message)
	}

	@Test
	fun `getWeatherForecast returns unexpected error`() = runBlocking {
		// Given
		`when`(api.getWeatherForecast(0.0, 0.0)).thenThrow(RuntimeException("Unexpected error"))

		// When
		val result = repository.getWeatherForecast(0.0, 0.0)

		// Then
		assertTrue(result is Resource.Error)
		assertEquals("An unexpected error occurred. Please try again later.", result.message)
	}
}
