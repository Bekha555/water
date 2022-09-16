package com.example.beta1

object DataObject {
    var listdata = mutableListOf<WaterInfo>()

    fun setData(title: String){
        listdata.add(WaterInfo(title = title))
    }
    fun getAllData():List<WaterInfo> {
        return listdata
    }
}