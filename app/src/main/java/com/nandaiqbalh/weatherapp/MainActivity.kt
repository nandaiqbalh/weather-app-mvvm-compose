package com.nandaiqbalh.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nandaiqbalh.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
	private val viewModel by viewModels<MainViewModel>()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		installSplashScreen().apply {
			setKeepOnScreenCondition {
				viewModel.splashCondition.value
			}
		}

		WindowCompat.setDecorFitsSystemWindows(window, false)

		setContent {
			WeatherAppTheme {
				// A surface container using the 'background' color from the theme

				val isSystemInDarkMode = isSystemInDarkTheme()
				val systemController = rememberSystemUiController()

				SideEffect {
					systemController.setSystemBarsColor(
						color = Color.Transparent,
						darkIcons = !isSystemInDarkMode
					)
				}

				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background
				) {

				}
			}
		}
	}
}
