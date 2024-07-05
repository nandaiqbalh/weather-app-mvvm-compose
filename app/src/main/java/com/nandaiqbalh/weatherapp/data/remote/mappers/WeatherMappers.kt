package com.nandaiqbalh.weatherapp.data.remote.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherDataDto
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import com.nandaiqbalh.weatherapp.domain.models.WeatherData
import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.models.WeatherType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<LocalDate, List<WeatherData>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        IndexedWeatherData(
            index = index,
            data = WeatherData(
                time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                temperatureCelsius = temperature,
                pressure = pressure,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        it.data.time.toLocalDate()
    }.mapValues {
        it.value.map { it.data }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherResponse.toWeatherInfo(): WeatherInfo {
    val dailyWeatherDataMap = daily.toWeatherDataMap()
    val hourlyWeatherDataMap = hourly.toWeatherDataMap()
    val now = LocalDateTime.now()
    val currentWeatherData = hourlyWeatherDataMap[now.toLocalDate()]?.find {
        val hour = if (now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = dailyWeatherDataMap,
        hourlyWeatherData = hourlyWeatherDataMap,
        currentWeatherData = currentWeatherData
    )
}
