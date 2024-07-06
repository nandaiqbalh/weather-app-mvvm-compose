package com.nandaiqbalh.weatherapp.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(
	onRefresh: () -> Unit,
	onExit: () -> Unit,
) {
	TopAppBar(
		title = { Text(text = "Weather App") },
		colors = TopAppBarColors(
			containerColor = Color.DarkGray,
			titleContentColor = Color.White,
			navigationIconContentColor = Color.White,
			scrolledContainerColor = Color.DarkGray,
			actionIconContentColor = Color.White
		),
		actions = {
			Row(
				horizontalArrangement = Arrangement.End,
				modifier = Modifier.fillMaxWidth()
			) {
				// Refresh Button
				IconButton(
					onClick = { onRefresh() },
					modifier = Modifier.padding(end = 8.dp)
				) {
					Icon(
						imageVector = Icons.Default.Refresh,
						contentDescription = "Refresh",
						tint = Color.White
					)
				}

				// Exit Button
				IconButton(
					onClick = { onExit() }
				) {
					Icon(
						imageVector = Icons.Default.Close,
						contentDescription = "Exit",
						tint = Color.White
					)
				}
			}
		}
	)
}


