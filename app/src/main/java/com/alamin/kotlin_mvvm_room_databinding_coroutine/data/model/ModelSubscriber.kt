package com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "subscriber_data_table")
data class ModelSubscriber (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var email: String)