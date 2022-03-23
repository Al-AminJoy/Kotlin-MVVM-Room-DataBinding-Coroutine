package com.alamin.kotlin_mvvm_room_databinding_coroutine.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.alamin.kotlin_mvvm_room_databinding_coroutine.data.model.ModelSubscriber
import com.alamin.kotlin_mvvm_room_databinding_coroutine.databinding.ItemViewBinding

class SubscriberAdapter(private val subscriberList: List<ModelSubscriber>):
    RecyclerView.Adapter<SubscriberAdapter.SubscriberViewHolder>() {

    inner class SubscriberViewHolder(private val binding : ItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind (subscriber: ModelSubscriber){
            binding.subscriber = subscriber;
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubscriberAdapter.SubscriberViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        val view = ItemViewBinding.inflate(inflater,parent,false);
        return SubscriberViewHolder(view);
    }

    override fun onBindViewHolder(holder: SubscriberAdapter.SubscriberViewHolder, position: Int) {
        holder.bind(subscriberList[position]);
    }

    override fun getItemCount(): Int {
        return subscriberList.size;
    }

}