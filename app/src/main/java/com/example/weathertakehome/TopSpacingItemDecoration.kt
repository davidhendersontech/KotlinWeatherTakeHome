package com.example.weathertakehome

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// class that takes in and sets padding value for recycler view items
class TopSpacingItemDecoration(private val padding: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = padding
    }
}