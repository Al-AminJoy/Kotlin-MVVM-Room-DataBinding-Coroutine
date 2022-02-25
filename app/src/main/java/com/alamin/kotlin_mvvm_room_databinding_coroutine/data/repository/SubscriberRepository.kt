package com.alamin.kotlin_mvvm_room_databinding_coroutine.data.repository

import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.dao.SubscriberDao
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model.ModelSubscriber

class SubscriberRepository (private val dao: SubscriberDao){
    val subscribers = dao.getAllSubscriber();

    suspend fun insert(modelSubscriber: ModelSubscriber){
         dao.insertSubscriber(modelSubscriber);
    }

    suspend fun update(modelSubscriber: ModelSubscriber) {
         dao.updateSubscriber(modelSubscriber)
    }
    suspend fun delete(subscriber: ModelSubscriber){
         dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll(){
         dao.deleteAllSubscribers()
    }
}