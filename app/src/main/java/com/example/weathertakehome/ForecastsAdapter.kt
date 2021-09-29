package com.example.weathertakehome

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weathertakehome.model.Period

class ForecastsAdapter(private val periods: List<Period>) :
    RecyclerView.Adapter<ForecastsAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val day: TextView = view.findViewById(R.id.forecast_day)
        val temperature: TextView = view.findViewById(R.id.forecast_temperature)
        val detailedForecast: TextView = view.findViewById(R.id.forecast_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.forecast_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastsAdapter.ViewHolder, position: Int) {
        holder.day.text = periods[position].name
        holder.temperature.text = periods[position].temperature.toString()
        holder.detailedForecast.text = periods[position].detailedForecast
    }

    override fun getItemCount() = periods.size

}