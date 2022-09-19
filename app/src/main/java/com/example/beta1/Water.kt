package com.example.beta1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Water")
data class Water(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val title: String? = null,
    val date: String? = null
)