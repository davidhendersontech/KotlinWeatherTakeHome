package com.example.weather

import com.example.weather.models.ForecastCard

class DataSource {

    companion object{
        fun createDataSet(): ArrayList<ForecastCard>{
            val list = ArrayList<ForecastCard>()
            list.add(
                ForecastCard(
                    "Tonight",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Wednesday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Thursday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            list.add(
                ForecastCard(
                    "Friday",
                    "69",
                    "Slightly cloudy with chance of showers"
                )
            )
            return list
        }

    }

}