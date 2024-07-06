package com.nandaiqbalh.weatherapp.presentation.home.components

import android.os.Build
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import com.nandaiqbalh.weatherapp.domain.models.WeatherDataPerHour
import com.nandaiqbalh.weatherapp.presentation.Dimens
import java.time.format.DateTimeFormatter

@Composable
fun HourlyWeatherForecast(
	weatherData: WeatherDataPerHour,
	modifier: Modifier = Modifier,
	textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
	val formattedTime = remember(weatherData) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			weatherData.time.format(DateTimeFormatter.ofPattern("HH:mm"))
		} else {
			TODO("VERSION.SDK_INT < O")
		}
	}
	Column(
		modifier = modifier,
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.SpaceBetween
	) {
		Text(
			text = formattedTime,
			color = MaterialTheme.colorScheme.onSurface,
			fontSize = Dimens.SmallTextSize,
			modifier = Modifier.padding(vertical = Dimens.SmallPadding)
		)

		BarChart(
			temperature = weatherData.temperatureCelsius,
			modifier = Modifier
				.height(Dimens.BarHeight)
				.width(Dimens.SmallIconSize)
		)
		Text(
			text = "${weatherData.temperatureCelsius}°C",
			color = textColor,
			fontWeight = FontWeight.Bold,
			fontSize = Dimens.SmallTextSize
		)
	}
}

@Composable
fun BarChart(
	temperature: Double,
	modifier: Modifier = Modifier,
) {
	Canvas(modifier = modifier) {
		val barHeight = (temperature * size.height / 40).coerceIn(
			0.0,
			size.height.toDouble()
		) // Assuming max temperature as 40°C
		drawRect(
			color = Color.DarkGray, // Warna untuk bagian berisi (bar)
			size = androidx.compose.ui.geometry.Size(
				width = size.width,
				height = barHeight.toFloat()
			),
			topLeft = androidx.compose.ui.geometry.Offset(
				x = 0f,
				y = (size.height - barHeight).toFloat()
			)
		)
		drawRect(
			color = Color.DarkGray, // Warna untuk bagian kosong (background bar)
			size = androidx.compose.ui.geometry.Size(
				width = size.width,
				height = (size.height - barHeight).toFloat()
			),
			topLeft = androidx.compose.ui.geometry.Offset(x = 0f, y = 0f),
			style = Stroke(width = 1f)
		)
	}
}
