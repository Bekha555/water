package com.example.beta1

import android.content.Context
import android.view.View
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Water::class], version = 1, exportSchema = false)

abstract class WaterDataBase : RoomDatabase() {
    abstract fun waterDao(): WaterDao
}