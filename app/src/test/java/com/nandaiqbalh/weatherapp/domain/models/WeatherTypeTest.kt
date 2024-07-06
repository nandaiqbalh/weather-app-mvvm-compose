package com.nandaiqbalh.weatherapp.domain.models

import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherTypeTest {

	@Test
	fun `fromWMO converts weather code correctly`() {
		// Test cases for different weather codes
		assertEquals(WeatherType.ClearSky, WeatherType.fromWMO(0))
		assertEquals(WeatherType.MainlyClear, WeatherType.fromWMO(1))
		assertEquals(WeatherType.PartlyCloudy, WeatherType.fromWMO(2))
		assertEquals(WeatherType.Overcast, WeatherType.fromWMO(3))
		assertEquals(WeatherType.Foggy, WeatherType.fromWMO(45))
		assertEquals(WeatherType.DepositingRimeFog, WeatherType.fromWMO(48))
		assertEquals(WeatherType.LightDrizzle, WeatherType.fromWMO(51))
		assertEquals(WeatherType.ModerateDrizzle, WeatherType.fromWMO(53))
		assertEquals(WeatherType.DenseDrizzle, WeatherType.fromWMO(55))
		assertEquals(WeatherType.LightFreezingDrizzle, WeatherType.fromWMO(56))
		assertEquals(WeatherType.DenseFreezingDrizzle, WeatherType.fromWMO(57))
		assertEquals(WeatherType.SlightRain, WeatherType.fromWMO(61))
		assertEquals(WeatherType.ModerateRain, WeatherType.fromWMO(63))
		assertEquals(WeatherType.HeavyRain, WeatherType.fromWMO(65))
		assertEquals(WeatherType.LightFreezingDrizzle, WeatherType.fromWMO(66))
		assertEquals(WeatherType.HeavyFreezingRain, WeatherType.fromWMO(67))
		assertEquals(WeatherType.SlightSnowFall, WeatherType.fromWMO(71))
		assertEquals(WeatherType.ModerateSnowFall, WeatherType.fromWMO(73))
		assertEquals(WeatherType.HeavySnowFall, WeatherType.fromWMO(75))
		assertEquals(WeatherType.SnowGrains, WeatherType.fromWMO(77))
		assertEquals(WeatherType.SlightRainShowers, WeatherType.fromWMO(80))
		assertEquals(WeatherType.ModerateRainShowers, WeatherType.fromWMO(81))
		assertEquals(WeatherType.ViolentRainShowers, WeatherType.fromWMO(82))
		assertEquals(WeatherType.SlightSnowShowers, WeatherType.fromWMO(85))
		assertEquals(WeatherType.HeavySnowShowers, WeatherType.fromWMO(86))
		assertEquals(WeatherType.ModerateThunderstorm, WeatherType.fromWMO(95))
		assertEquals(WeatherType.SlightHailThunderstorm, WeatherType.fromWMO(96))
		assertEquals(WeatherType.HeavyHailThunderstorm, WeatherType.fromWMO(99))

		// Test default case
		assertEquals(WeatherType.ClearSky, WeatherType.fromWMO(-1))
	}
}
