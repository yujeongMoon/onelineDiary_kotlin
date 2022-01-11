package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.viewholder.SelectMoodViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderSelectMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class SelectMoodAdapter(private val viewModel: DiaryViewModel) : RecyclerView.Adapter<SelectMoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMoodViewHolder {
        val binding = ViewholderSelectMoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectMoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectMoodViewHolder, position: Int) {
        holder.onBind(position, viewModel)
    }

    override fun getItemCount(): Int {
        return viewModel.emojiStatus.value?.size ?: 0
    }
}