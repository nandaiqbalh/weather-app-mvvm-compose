package com.nandaiqbalh.weatherapp.presentation

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.junit.Assert.*
import org.junit.Test

class DimensTest {

	@Test
	fun testPaddingValues() {
		assertEquals(8.dp, Dimens.SmallPadding)
		assertEquals(12.dp, Dimens.MediumPadding)
		assertEquals(16.dp, Dimens.DefaultPadding)
		assertEquals(24.dp, Dimens.LargePadding)
	}

	@Test
	fun testIconSizes() {
		assertEquals(24.dp, Dimens.SmallIconSize)
		assertEquals(32.dp, Dimens.MediumIconSize)
		assertEquals(48.dp, Dimens.LargeIconSize)
	}

	@Test
	fun testTextSizes() {
		assertEquals(14.sp, Dimens.SmallTextSize)
		assertEquals(18.sp, Dimens.MediumTextSize)
		assertEquals(24.sp, Dimens.LargeTextSize)
	}

	@Test
	fun testOtherDimensions() {
		assertEquals(16.dp, Dimens.CardCornerRadius)
		assertEquals(120.dp, Dimens.WeatherImageSize)
		assertEquals(100.dp, Dimens.BarHeight)
	}
}
