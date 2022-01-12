package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.viewholder.MainPagerViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding
import com.example.onelinediary_kotlin.viewmodel.MainViewModel

class MainPagerAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<MainPagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerViewHolder {
        val binding = ViewholderMainDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainPagerViewHolder, position: Int) {
        holder.onBind(position, viewModel)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}