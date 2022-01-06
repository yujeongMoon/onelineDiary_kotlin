package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.adapter.viewholder.MainMoodViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainMoodAdapter(private val viewModel: DiaryViewModel) : RecyclerView.Adapter<MainMoodViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMoodViewHolder {
        val mainMoodBinding = ViewholderMoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainMoodViewHolder(mainMoodBinding)
    }

    override fun onBindViewHolder(holder: MainMoodViewHolder, position: Int) {
        holder.onBind(position, viewModel)
    }

    override fun getItemCount(): Int {
        return Utility.getCalenderItemCount(
            viewModel.year.value?.toInt() ?: Utility.getYearToInt(),
            viewModel.month.value?.toInt() ?: 1
        )
    }
}