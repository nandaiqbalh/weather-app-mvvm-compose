package com.nandaiqbalh.weatherapp.presentation.home.components

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nandaiqbalh.weatherapp.presentation.Dimens
import com.nandaiqbalh.weatherapp.presentation.common.CustomAppBar
import com.nandaiqbalh.weatherapp.presentation.home.MainViewModel

@Composable
fun MainView(viewModel: MainViewModel) {
	val context = LocalContext.current
	val scrollState = rememberScrollState()

	Scaffold(
		topBar = {
			CustomAppBar(
				onRefresh = { viewModel.refreshWeatherData() },
				onExit = {
					exitApp(
						context
					)
				})

		},
		content = {
			Column(
				modifier = Modifier
					.fillMaxSize()
					.verticalScroll(scrollState)
					.background(MaterialTheme.colorScheme.background)
					.padding(it)
			) {
				CurrentWeather(
					state = viewModel.stateHour,
					backgroundColor = Color.DarkGray
				)
				Spacer(modifier = Modifier.height(16.dp))
				ForecastWeather(
					statePerHour = viewModel.stateHour,
					statePerWeek = viewModel.stateWeek,
				)
			}

			viewModel.stateHour.error?.let { error ->
				Box(
					modifier = Modifier.fillMaxSize().padding(horizontal = Dimens.DefaultPadding),
					contentAlignment = Alignment.Center
				) {
					Text(
						text = error,
						color = Color.Red,
						textAlign = TextAlign.Center,
					)
				}

			}

			// Loading Indicator
			if (viewModel.stateHour.isLoading) {
				Box(
					modifier = Modifier.fillMaxSize(),
					contentAlignment = Alignment.Center,
				) {
					CircularProgressIndicator()
				}
			}
		}
	)
}

fun exitApp(context: Context) {
	(context as? Activity)?.finishAndRemoveTask()
}

