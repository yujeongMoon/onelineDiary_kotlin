package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.adapter.viewholder.MainMoodViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.MainViewModel

class MainMoodAdapter(private val year: Int, private val month: Int, private val viewModel: MainViewModel) : RecyclerView.Adapter<MainMoodViewHolder>() {

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMoodViewHolder {
        val binding = ViewholderMoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainMoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainMoodViewHolder, position: Int) {
        val startDayInMonth = Utility.getDayOfWeek(year, month, 1) - 1
        val day = (position - startDayInMonth) + 1
        holder.onBind(year, month, day, viewModel)
    }

    override fun getItemCount(): Int {
        return Utility.getCalenderItemCount(year, month)
    }
}