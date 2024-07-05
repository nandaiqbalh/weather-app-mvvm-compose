package com.nandaiqbalh.weatherapp.data.remote.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.nandaiqbalh.weatherapp.data.remote.mappers.toWeatherInfo
import com.nandaiqbalh.weatherapp.data.remote.service.WeatherApi
import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.repository.WeatherRepository
import com.nandaiqbalh.weatherapp.domain.util.Resource
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherForecast(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.", null)
        }
    }
}