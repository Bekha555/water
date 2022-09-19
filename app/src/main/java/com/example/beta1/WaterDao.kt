package com.example.beta1

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WaterDao {
    @Insert
    suspend fun insertTask(entity: Water)

    @Query("SELECT * FROM water")
    fun getAllData(): LiveData<List<Water>>

    @Query("DELETE FROM WATER")
    suspend fun clearData()
}