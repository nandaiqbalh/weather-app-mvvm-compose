package com.nandaiqbalh.weatherapp.presentation.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.junit.Assert.assertEquals
import org.junit.Test

class TypeTest {

	@Test
	fun testTypography() {
		// Define expected typography styles from your theme
		val expectedDisplaySmall = TextStyle(
			fontSize = 24.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 36.sp
		)
		val expectedDisplayMedium = TextStyle(
			fontSize = 32.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 48.sp
		)
		val expectedBodySmall = TextStyle(
			fontSize = 14.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 21.sp
		)
		val expectedBodyMedium = TextStyle(
			fontSize = 16.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 24.sp
		)
		val expectedLabelSmall = TextStyle(
			fontSize = 13.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 19.sp
		)

		// Verify each typography style
		assertEquals(expectedDisplaySmall, Typography.displaySmall)
		assertEquals(expectedDisplayMedium, Typography.displayMedium)
		assertEquals(expectedBodySmall, Typography.bodySmall)
		assertEquals(expectedBodyMedium, Typography.bodyMedium)
		assertEquals(expectedLabelSmall, Typography.labelSmall)
	}

	@Test
	fun testDisplaySmallTextStyle() {
		val expectedTextStyle = TextStyle(
			fontSize = 24.sp,
			fontFamily = Poppins,
			fontWeight = FontWeight.Normal,
			lineHeight = 36.sp
		)

		assertEquals(expectedTextStyle, Typography.displaySmall)
	}

}
