package com.nandaiqbalh.weatherapp.presentation.home.components

import android.os.Build
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nandaiqbalh.weatherapp.domain.models.WeatherDataPerWeek
import java.time.format.DateTimeFormatter

@Composable
fun WeeklyWeatherTable(
	weatherDataPerWeek: Map<Int, List<WeatherDataPerWeek>>,
	modifier: Modifier = Modifier
) {
	Column(modifier = modifier) {
		// Header row
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Text(
				text = "Date",
				modifier = Modifier.weight(1f),
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "Temp.",
				modifier = Modifier.weight(1f),
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.bodyMedium
			)
			Text(
				text = "Weather",
				modifier = Modifier.weight(1f),
				color = MaterialTheme.colorScheme.onSurface,
				style = MaterialTheme.typography.bodyMedium
			)
		}
		Spacer(modifier = Modifier.height(8.dp))

		weatherDataPerWeek.keys.sorted().forEach { dateIndex ->
			val weatherDataForDay = weatherDataPerWeek[dateIndex]

			weatherDataForDay?.forEach { weatherData ->
				Row(
					modifier = Modifier.fillMaxWidth(),
					verticalAlignment = Alignment.CenterVertically,
					horizontalArrangement = Arrangement.SpaceBetween
				) {
					val formattedDate = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
						weatherData.time.format(DateTimeFormatter.ofPattern("d MMM yyyy"))
					} else {
						weatherData.time.toString() // Handle for older versions
					}
					Text(
						text = formattedDate,
						modifier = Modifier.weight(1f),
						color = MaterialTheme.colorScheme.onSurface // Color for date
					)
					Text(
						text = "${weatherData.temperatureCelsius}°C",
						modifier = Modifier.weight(1f),
						color = MaterialTheme.colorScheme.onSurface // Color for temperature
					)
					Text(
						text = weatherData.weatherType.weatherDesc,
						modifier = Modifier.weight(1f),
						color = MaterialTheme.colorScheme.onSurface // Color for weather description
					)
				}
				Spacer(modifier = Modifier.height(8.dp))
			}
		}
	}
}
