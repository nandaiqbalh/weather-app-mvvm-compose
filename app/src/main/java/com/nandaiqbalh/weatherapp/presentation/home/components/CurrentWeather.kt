package com.nandaiqbalh.weatherapp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.nandaiqbalh.weatherapp.R
import com.nandaiqbalh.weatherapp.presentation.Dimens
import com.nandaiqbalh.weatherapp.presentation.common.ParameterDisplay
import com.nandaiqbalh.weatherapp.presentation.helper.WeatherStatePerHour
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(
    state: WeatherStatePerHour,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(Dimens.CardCornerRadius),
            modifier = modifier.padding(horizontal = Dimens.DefaultPadding, vertical = Dimens.DefaultPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.DefaultPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.WeatherImageSize)
                )
                Spacer(modifier = Modifier.height(Dimens.DefaultPadding))
                Text(
                    text = "${data.temperatureCelsius}°C",
                    fontSize = Dimens.LargeTextSize,
                    color = Color.White,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(Dimens.DefaultPadding))
                Text(
                    text = data.weatherType.weatherDesc,
                    fontSize = Dimens.MediumTextSize,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(Dimens.LargePadding))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ParameterDisplay(
                        value = data.pressure.roundToInt(),
                        unit = "hPa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )
                    ParameterDisplay(
                        value = data.humidity.roundToInt(),
                        unit = "%",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop),
                        iconTint = Color.White,
                        textStyle = TextStyle(color = Color.White)
                    )

                }
            }
        }
    }
}
