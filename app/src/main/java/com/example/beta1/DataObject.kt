package com.example.beta1

import android.widget.TextView
import kotlinx.android.synthetic.main.item_layout.view.*

object DataObject {
    var listdata = mutableListOf<WaterInfo>()

    fun setData(title: String, date: String, sections: String, value: String) {
        listdata.add(WaterInfo(title = title, date = date, sections = sections, value = value))

    }

    fun getAllData(): List<WaterInfo> {
        return listdata
    }
}