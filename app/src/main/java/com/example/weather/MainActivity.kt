package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val forecasts = DataSource.createDataSet()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.adapter = ForecastRecyclerApadter(this, forecasts)
        // set item padding
        val topSpacingDecoration = TopSpacingItemDecoration(15)
        recyclerView.addItemDecoration(topSpacingDecoration)
        
        recyclerView.setHasFixedSize(true)
    }

}