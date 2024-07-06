package com.nandaiqbalh.weatherapp.data.remote.dto

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WeatherResponseTest {

	private lateinit var moshi: Moshi
	private lateinit var jsonAdapter: JsonAdapter<WeatherResponse>

	@Before
	fun setup() {
		moshi = Moshi.Builder().build()
		jsonAdapter = moshi.adapter(WeatherResponse::class.java)
	}

	@Test
	fun `weather response parses correctly`() {
		// Sample JSON string representing WeatherResponse
		val json = """
            {
                "hourly": {
                    "time": ["2024-07-06T12:00:00Z", "2024-07-06T15:00:00Z"],
                    "temperature_2m": [25.0, 27.5],
                    "weathercode": [800, 801],
                    "pressure_msl": [1015.0, 1016.5],
                    "relativehumidity_2m": [65.0, 70.0]
                }
            }
        """.trimIndent()

		// Deserialize JSON into WeatherResponse object
		val weatherResponse = jsonAdapter.fromJson(json)

		// Assert values
		assertEquals(listOf("2024-07-06T12:00:00Z", "2024-07-06T15:00:00Z"), weatherResponse?.weatherData?.time)
		assertEquals(listOf(25.0, 27.5), weatherResponse?.weatherData?.temperatures)
		assertEquals(listOf(800, 801), weatherResponse?.weatherData?.weatherCodes)
		assertEquals(listOf(1015.0, 1016.5), weatherResponse?.weatherData?.pressures)
		assertEquals(listOf(65.0, 70.0), weatherResponse?.weatherData?.humidities)
	}
}
