package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.viewholder.SelectMoodViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderSelectMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.MainViewModel
import com.example.onelinediary_kotlin.viewmodel.NewDiaryViewModel

class SelectMoodAdapter(private val viewModel: NewDiaryViewModel) : RecyclerView.Adapter<SelectMoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectMoodViewHolder {
        val binding = ViewholderSelectMoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SelectMoodViewHolder(this, binding)
    }

    override fun onBindViewHolder(holder: SelectMoodViewHolder, position: Int) {
        holder.onBind(position, viewModel)
    }

    override fun getItemCount(): Int {
        return viewModel.emoji.size
    }
}