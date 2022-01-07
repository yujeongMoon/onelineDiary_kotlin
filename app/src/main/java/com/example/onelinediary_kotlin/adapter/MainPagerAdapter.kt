package com.example.onelinediary_kotlin.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.viewholder.MainPagerViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainPagerAdapter(private val owner: LifecycleOwner, private val viewModel: DiaryViewModel) : RecyclerView.Adapter<MainPagerViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerViewHolder {
        val mainPagerBinding = ViewholderMainDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainPagerViewHolder(mainPagerBinding)
    }

    override fun onBindViewHolder(holder: MainPagerViewHolder, position: Int) {
        holder.onBind(position, viewModel)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}