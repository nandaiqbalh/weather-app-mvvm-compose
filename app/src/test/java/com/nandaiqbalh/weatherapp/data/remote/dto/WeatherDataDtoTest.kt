package com.nandaiqbalh.weatherapp.data.remote.dto

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherDataDtoTest {

	private lateinit var moshi: Moshi
	private lateinit var jsonAdapter: JsonAdapter<WeatherDataDto>

	@Before
	fun setup() {
		moshi = Moshi.Builder().build()
		jsonAdapter = moshi.adapter(WeatherDataDto::class.java)
	}

	@Test
	fun `weather data dto parses correctly`() {
		// Sample JSON string representing WeatherDataDto
		val json = """
            {
                "time": ["2024-07-06T12:00:00Z", "2024-07-06T15:00:00Z"],
                "temperature_2m": [25.0, 27.5],
                "weathercode": [800, 801],
                "pressure_msl": [1015.0, 1016.5],
                "relativehumidity_2m": [65.0, 70.0]
            }
        """.trimIndent()

		// Deserialize JSON into WeatherDataDto object
		val weatherDataDto = jsonAdapter.fromJson(json)

		// Assert values
		assertEquals(listOf("2024-07-06T12:00:00Z", "2024-07-06T15:00:00Z"), weatherDataDto?.time)
		assertEquals(listOf(25.0, 27.5), weatherDataDto?.temperatures)
		assertEquals(listOf(800, 801), weatherDataDto?.weatherCodes)
		assertEquals(listOf(1015.0, 1016.5), weatherDataDto?.pressures)
		assertEquals(listOf(65.0, 70.0), weatherDataDto?.humidities)
	}
}
