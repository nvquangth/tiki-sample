package com.example.tikisample.widgets

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tikisample.R

class SpacesItemDecoration(context: Context) : RecyclerView.ItemDecoration() {
    private var space: Int = context.resources.getDimensionPixelSize(R.dimen.dp_10)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.left = 0
        } else {
            outRect.left = space
        }
    }
}