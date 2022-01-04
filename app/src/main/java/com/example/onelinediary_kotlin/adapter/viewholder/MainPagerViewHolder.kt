package com.example.onelinediary_kotlin.adapter.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding
import com.example.onelinediary_kotlin.entity.Diary

class MainPagerViewHolder(private val binding: ViewholderMainDiaryBinding)
    : RecyclerView.ViewHolder(binding.root) {

    fun onBind(diary: Diary) {
        with(binding) {
            year.text = diary.year
            month.text = diary.month
        }
    }

}