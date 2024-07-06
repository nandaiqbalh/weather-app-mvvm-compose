package com.nandaiqbalh.weatherapp.data.remote.mappers

import android.os.Build
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherDataDto
import com.nandaiqbalh.weatherapp.data.remote.dto.WeatherResponse
import com.nandaiqbalh.weatherapp.domain.models.WeatherDataPerHour
import com.nandaiqbalh.weatherapp.domain.models.WeatherDataPerWeek
import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.models.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.WeekFields
import java.util.Locale

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherDataPerHour
)

private data class IndexedWeatherDataPerWeek(
    val index: Int,
    val data: WeatherDataPerWeek
)

fun WeatherDataDto.toWeatherDataMap(): Map<Int, List<WeatherDataPerHour>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            IndexedWeatherData(
                index = index,
                data = WeatherDataPerHour(
                    time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                    temperatureCelsius = temperature,
                    pressure = pressure,
                    humidity = humidity,
                    weatherType = WeatherType.fromWMO(weatherCode)
                )
            )
        } else {
            TODO("VERSION.SDK_INT < O")
        }
    }.groupBy {
        it.index / 24
    }.mapValues { it ->
        it.value.map { it.data }
    }
}

fun WeatherDataDto.toWeatherDataPerWeek(): Map<Int, List<WeatherDataPerWeek>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val pressure = pressures[index]
        val humidity = humidities[index]

        val localDateTime = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME)
        } else {
            TODO("VERSION.SDK_INT < O")
        }

        IndexedWeatherDataPerWeek(
            index = index,
            data = WeatherDataPerWeek(
                time = localDateTime,
                temperatureCelsius = temperature,
                pressure = pressure,
                humidity = humidity,
                weatherType = WeatherType.fromWMO(weatherCode)
            )
        )
    }.groupBy {
        val localDateTime = it.data.time
        val weekFields = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            WeekFields.of(Locale.getDefault())
        } else {
            TODO("VERSION.SDK_INT < O")
        }
        val weekOfYear = localDateTime.get(weekFields.weekOfYear())
        weekOfYear
    }.mapValues {
        it.value.distinctBy { it.data.time.toLocalDate() } // Menggunakan distinctBy untuk mempertahankan satu baris data per tanggal unik
            .map { it.data }
    }
}

fun WeatherResponse.toWeatherInfo(): WeatherInfo {
    val weatherDataMap = weatherData.toWeatherDataMap()
    val weatherDataPerWeek = weatherData.toWeatherDataPerWeek()
    val now = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        LocalDateTime.now()
    } else {
        TODO("VERSION.SDK_INT < O")
    }
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherInfo(
        weatherDataPerDay = weatherDataMap,
        weatherDataPerWeek = weatherDataPerWeek,
        currentWeatherData = currentWeatherData
    )
}
