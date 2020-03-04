package com.software.noelvillaman.people10app.classes

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginCustomDecorator (private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View,
                                    parent: RecyclerView, state: RecyclerView.State) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left =  spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }

}