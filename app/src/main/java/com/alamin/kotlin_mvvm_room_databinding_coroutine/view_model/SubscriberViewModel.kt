package com.alamin.kotlin_mvvm_room_databinding_coroutine.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.LocalDatabase
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.dao.SubscriberDao
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model.ModelSubscriber
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.repository.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriberViewModel(application: Application): AndroidViewModel(application) {

    private val repository: SubscriberRepository;


     val inputName = MutableLiveData<String>();
     val inputEmail = MutableLiveData<String>();
     val saveOrUpdateButtonText = MutableLiveData<String>();
     val clearAllOrDeleteButtonText = MutableLiveData<String>();


    init {
        val subscriberDao = LocalDatabase.getInstance(application).subscriberDao();
        repository = SubscriberRepository(subscriberDao);
        saveOrUpdateButtonText.value = "Save";
        clearAllOrDeleteButtonText.value = "Clear All"
    }

    fun saveOrUpdate(){
        val name = inputName.value!!;
        val email = inputEmail.value!!;
        insertSubscriber(ModelSubscriber(0,name,email));
        inputName.value = "";
        inputEmail.value = "";
    }
    private fun insertSubscriber(modelSubscriber: ModelSubscriber) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(modelSubscriber);
        }
    }

    fun getAllSubscribers(): LiveData<List<ModelSubscriber>>{
        return repository.subscribers;
    }

}