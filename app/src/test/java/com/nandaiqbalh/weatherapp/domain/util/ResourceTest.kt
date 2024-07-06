package com.nandaiqbalh.weatherapp.domain.util

import org.junit.Assert.assertEquals
import org.junit.Test

class ResourceTest {

	@Test
	fun `Success resource should hold correct data`() {
		val data = "Success"
		val resource = Resource.Success(data)

		assertEquals(data, resource.data)
		assertEquals(null, resource.message)
		assertEquals(null, resource.exception)
	}

	@Test
	fun `Empty resource should hold correct data`() {
		val data = "Empty"
		val resource = Resource.Empty(data)

		assertEquals(data, resource.payload)
		assertEquals(null, resource.message)
		assertEquals(null, resource.exception)
	}

	@Test
	fun `Error resource should hold correct message and data`() {
		val message = "Error message"
		val data = "Error data"
		val resource = Resource.Error(message, data)

		assertEquals(data, resource.payload)
		assertEquals(message, resource.message)
		assertEquals(null, resource.exception)
	}

	@Test
	fun `Loading resource should hold correct data`() {
		val data = "Loading"
		val resource = Resource.Loading(data)

		assertEquals(data, resource.payload)
		assertEquals(null, resource.message)
		assertEquals(null, resource.exception)
	}
}
