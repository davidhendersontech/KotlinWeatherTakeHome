package com.example.weathertakehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.weathertakehome.model.Forecast
import com.example.weathertakehome.model.Forecasts
import com.example.weathertakehome.model.Period
import com.example.weathertakehome.network.ForecastApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // initialize retrofit for api calls
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.weather.gov")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ForecastApiService::class.java)
        // retrofit call to weather.gov
        api.fetchForecasts().enqueue(object : Callback<Forecasts> {
            override fun onResponse(call: Call<Forecasts>, response: Response<Forecasts>) {
                val data = response.body()!!
                val periods = mutableListOf<Period>()

                for (period in data.properties.periods) {
                    periods.add(
                        Period(
                            name = period.name,
                            temperature = period.temperature,
                            detailedForecast = period.detailedForecast
                        )
                    )
                }
                showData(periods.take(10)) // create recycler view with first 10 forecasts
            }

            override fun onFailure(call: Call<Forecasts>, t: Throwable) {
                Log.d("DEBUG", t.toString())
            }
        })
    }

    private fun showData(periods: List<Period>) {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val topSpacingItemDecoration = TopSpacingItemDecoration(15)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ForecastsAdapter(periods)
            addItemDecoration(topSpacingItemDecoration)
        }
    }
}