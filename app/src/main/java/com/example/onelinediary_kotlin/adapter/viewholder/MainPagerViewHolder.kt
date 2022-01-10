package com.example.onelinediary_kotlin.adapter.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.MainMoodAdapter
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainPagerViewHolder(private val binding: ViewholderMainDiaryBinding)
    : RecyclerView.ViewHolder(binding.root) {

    private val gridLayoutManager = GridLayoutManager(binding.root.context, 7)

    fun onBind(position: Int, viewModel: DiaryViewModel) {
        val yearWithPosition = position.div(12)
        val monthWithPosition = position.rem(12) + 1

        with(binding) {
            // 연도, 월 설정
            // layoutPosition
            // adapterPosition
            year.text = yearWithPosition.toString()
            month.text = monthWithPosition.toString()

            // 리사이클러뷰 설정
            moodLayout.layoutManager = gridLayoutManager
            val mainMoodAdapter = MainMoodAdapter(yearWithPosition, monthWithPosition, viewModel)
            moodLayout.adapter = mainMoodAdapter
        }
    }
}