package com.example.beta1

object DataObject {
    var listdata = mutableListOf<WaterInfo>()

    fun setData(title: String, date: String) {
        listdata.add(WaterInfo(title = title, date = date))

    }

    fun getAllData(): List<WaterInfo> {
        return listdata
    }
}