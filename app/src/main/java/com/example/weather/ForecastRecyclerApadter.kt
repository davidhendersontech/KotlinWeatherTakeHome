package com.example.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView

import androidx.recyclerview.widget.RecyclerView
import com.example.weather.models.ForecastCard
import org.w3c.dom.Text

class ForecastRecyclerApadter(
    private val context: Context,
    private val dataset: List<ForecastCard>
) : RecyclerView.Adapter<ForecastRecyclerApadter.ForecastViewHolder>(){

    class ForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val forecastDay: TextView = view.findViewById(R.id.forecast_day)
        val forecastTemperature: TextView = view.findViewById(R.id.forecast_temperature)
        val forecastDescription: TextView = view.findViewById(R.id.forecast_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        //create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_forecast_item, parent, false)
        return ForecastViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val forecast = dataset[position]
        holder.forecastDay.text = forecast.day
        holder.forecastTemperature.text = forecast.temperature
        holder.forecastDescription.text = forecast.detailedForecast
    }

    override fun getItemCount() = dataset.size


}