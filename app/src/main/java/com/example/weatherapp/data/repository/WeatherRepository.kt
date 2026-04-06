package com.example.weatherapp.data.repository

import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.RetrofitInstance
import com.mansi.weatherapp.BuildConfig

class WeatherRepository {
    suspend fun getWeather(city: String): WeatherResponse {
        return RetrofitInstance.api.getWeather(
            city, BuildConfig.WEATHER_API_KEY

        )
    }
}