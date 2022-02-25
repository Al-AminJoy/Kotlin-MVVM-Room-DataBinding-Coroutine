package com.alamin.kotlin_mvvm_room_databinding_coroutine.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.dao.SubscriberDao
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model.ModelSubscriber

@Database(entities = [ModelSubscriber::class], version = 1, exportSchema = false)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun subscriberDao(): SubscriberDao;

    companion object{
        @Volatile
        private var INSTANCE: LocalDatabase? = null;

        fun  getInstance(context: Context): LocalDatabase{
            synchronized(this){
                var instance = INSTANCE;
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        LocalDatabase::class.java,
                        "local_database"
                    ).build();
                }
                return instance;
            }
        }
    }
}