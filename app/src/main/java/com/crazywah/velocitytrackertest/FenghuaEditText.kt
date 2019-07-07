package com.crazywah.velocitytrackertest

import android.content.Context
import androidx.appcompat.widget.AppCompatEditText

class FenghuaEditText(context: Context?) : AppCompatEditText(context) {

    init {

    }

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)
    }

    override fun onTextContextMenuItem(id: Int): Boolean {

        return super.onTextContextMenuItem(id)
    }

}