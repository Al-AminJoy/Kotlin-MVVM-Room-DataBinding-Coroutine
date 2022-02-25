package com.alamin.kotlin_mvvm_room_databinding_coroutine.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model.ModelSubscriber

@Dao
interface SubscriberDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertSubscriber(modelSubscriber: ModelSubscriber)

    @Update
     fun updateSubscriber(modelSubscriber: ModelSubscriber)

    @Delete
     fun deleteSubscriber(subscriber: ModelSubscriber)

    @Query("DELETE FROM subscriber_data_table" )
     fun deleteAllSubscribers()

    @Query("SELECT * FROM subscriber_data_table")
    fun getAllSubscriber(): LiveData<List<ModelSubscriber>>
}