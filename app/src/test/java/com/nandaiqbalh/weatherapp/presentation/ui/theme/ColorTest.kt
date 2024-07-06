package com.nandaiqbalh.weatherapp.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Test

class ColorTest {

	@Test
	fun `test dark color palette`() {
		assertEquals(Color(0xFF1A1A1A), Black)
		assertEquals(Color(0xFF1976D2), BlueDark)
		assertEquals(Color(0xFFB00020), DarkRed)
		assertEquals(Color(0xFF333333), DarkGray)
	}

	@Test
	fun `test light color palette`() {
		assertEquals(Color(0xFF2196F3), BlueLight)
		assertEquals(Color(0xFFEF5350), LightRed)
	}
}
