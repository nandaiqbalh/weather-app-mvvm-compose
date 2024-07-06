package com.nandaiqbalh.weatherapp.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nandaiqbalh.weatherapp.presentation.Dimens
import com.nandaiqbalh.weatherapp.presentation.helper.WeatherStatePerHour
import com.nandaiqbalh.weatherapp.presentation.helper.WeatherStatePerWeek

@Composable
fun ForecastWeather(
	statePerHour: WeatherStatePerHour,
	statePerWeek: WeatherStatePerWeek,
	modifier: Modifier = Modifier,
) {

	Column(
		modifier = modifier
			.fillMaxWidth()
			.padding(horizontal = Dimens.DefaultPadding)
	) {

		statePerHour.weatherInfo?.weatherDataPerDay?.get(0)?.let { data ->
			Column {
				Text(
					text = "Today Weather Forecast",
					fontSize = 20.sp,
					color = MaterialTheme.colorScheme.onSurface,
					modifier = Modifier.padding(vertical = Dimens.MediumPadding)
				)
				LazyRow(content = {
					items(data) { weatherData ->
						HourlyWeatherForecast(
							weatherData = weatherData,
							modifier = Modifier
								.height(200.dp)
								.padding(horizontal = Dimens.MediumPadding)
						)
					}
				})
			}
		}
		Spacer(modifier = Modifier.height(Dimens.DefaultPadding))

		// Display the weather forecast for the week in a single table
		statePerWeek.weatherInfo?.weatherDataPerWeek?.let { weatherDataPerWeek ->
			Column {
				Text(
					text = "Weekly Weather Forecast",
					fontSize = 20.sp,
					color = MaterialTheme.colorScheme.onSurface,
					modifier = Modifier.padding(vertical = Dimens.MediumPadding)
				)
				WeeklyWeatherTable(weatherDataPerWeek)
			}
		}
	}
}
