package com.nandaiqbalh.weatherapp.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nandaiqbalh.weatherapp.domain.location.LocationTracker
import com.nandaiqbalh.weatherapp.domain.repository.WeatherRepository
import com.nandaiqbalh.weatherapp.domain.util.Resource
import com.nandaiqbalh.weatherapp.presentation.helper.WeatherStatePerHour
import com.nandaiqbalh.weatherapp.presentation.helper.WeatherStatePerWeek
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: WeatherRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    var stateHour by mutableStateOf(WeatherStatePerHour())
        private set

    var stateWeek by mutableStateOf(WeatherStatePerWeek())
        private set

    fun getWeatherForecast() {
        viewModelScope.launch {
            stateHour = stateHour.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let { location ->
                when (val result = repository.getWeatherForecast(location.latitude, location.longitude)) {
                    is Resource.Success -> {
                        stateHour = stateHour.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                        // Update stateWeek with weather info per week
                        stateWeek = stateWeek.copy(
                            weatherInfo = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        stateHour = stateHour.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                        // Handle error for stateWeek if needed
                        stateWeek = stateWeek.copy(
                            weatherInfo = null,
                            isLoading = false,
                            error = result.message
                        )
                    }
                    // Handle other Resource states if necessary
                    is Resource.Empty -> TODO()
                    is Resource.Loading -> TODO()
                }
            } ?: kotlin.run {
                stateHour = stateHour.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
                // Update stateWeek error if location retrieval fails
                stateWeek = stateWeek.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }

    fun refreshWeatherData() {
        getWeatherForecast()
    }
}
