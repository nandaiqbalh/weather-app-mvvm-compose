package com.nandaiqbalh.weatherapp.data.remote.repository

import com.nandaiqbalh.weatherapp.data.remote.mappers.toWeatherInfo
import com.nandaiqbalh.weatherapp.data.remote.service.WeatherApi
import com.nandaiqbalh.weatherapp.domain.models.WeatherInfo
import com.nandaiqbalh.weatherapp.domain.repository.WeatherRepository
import com.nandaiqbalh.weatherapp.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {

    override suspend fun getWeatherForecast(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherForecast(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: IOException) {
            Resource.Error("There was a problem with your network connection. Please check your internet connection and try again.", null)
        } catch (e: HttpException) {
            Resource.Error("There was an unexpected server error. Please try again later.", null)
        } catch (e: Exception) {
            Resource.Error("An unexpected error occurred. Please try again later.", null)
        }
    }
}