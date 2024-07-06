package com.nandaiqbalh.weatherapp.data.remote.mappers

import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherDataDto
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
import org.mockito.Mockito.mock

class WeatherMappersTest {

	@Test
	fun `toWeatherDataMap throws exception for API level below O`() {
		val weatherDataDto = mock(WeatherDataDto::class.java)
		val exception = assertThrows(UnsupportedOperationException::class.java) {
			weatherDataDto.toWeatherDataMap()
		}
		assertEquals("This feature requires API level 26 or higher", exception.message)
	}

	@Test
	fun `toWeatherDataPerWeek throws exception for API level below O`() {
		val weatherDataDto = mock(WeatherDataDto::class.java)
		val exception = assertThrows(UnsupportedOperationException::class.java) {
			weatherDataDto.toWeatherDataPerWeek()
		}
		assertEquals("This feature requires API level 26 or higher", exception.message)
	}



	@Test
	fun `toWeatherInfo throws exception for API level below O`() {
		val weatherResponse = mock(WeatherResponse::class.java)
		val exception = assertThrows(UnsupportedOperationException::class.java) {
			weatherResponse.toWeatherInfo()
		}
		assertEquals("This feature requires API level 26 or higher", exception.message)
	}

}
