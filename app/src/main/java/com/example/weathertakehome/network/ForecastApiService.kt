package com.example.weathertakehome.network

import com.example.weathertakehome.model.Forecasts
import com.example.weathertakehome.model.Period
import retrofit2.Call
import retrofit2.http.GET

interface ForecastApiService {
    @GET("gridpoints/TOP/30,81/forecast")
    fun fetchForecasts(): Call<Forecasts>
}