package com.alamin.kotlin_mvvm_room_databinding_coroutine.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alamin.kotlin_mvvm_room_databinding_coroutine.R
import com.alamin.kotlin_mvvm_room_databinding_coroutine.databinding.ActivityMainBinding
import com.alamin.kotlin_mvvm_room_databinding_coroutine.view.adapter.SubscriberAdapter
import com.alamin.kotlin_mvvm_room_databinding_coroutine.view_model.SubscriberViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding;
    private lateinit var viewModel: SubscriberViewModel;
    lateinit var manager: RecyclerView.LayoutManager;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);
        viewModel = ViewModelProvider(this).get(SubscriberViewModel::class.java);
        binding.subscriberViewModel = viewModel;
        binding.lifecycleOwner = this;
        manager = LinearLayoutManager(this);
        viewModel.getAllSubscribers().observe(this, Observer {
            binding.recyclerView.apply {
                layoutManager = manager;
                adapter = SubscriberAdapter(it);
            }
        })
    }
}