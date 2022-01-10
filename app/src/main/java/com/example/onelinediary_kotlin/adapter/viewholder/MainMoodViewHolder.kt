package com.example.onelinediary_kotlin.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.R
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainMoodViewHolder(private val binding: ViewholderMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private var diary: Diary? = null

    fun onBind(year: Int, month: Int, day: Int, viewModel: DiaryViewModel) {
         with(binding) {
            if (day <= 0) {
                tvDay.visibility = View.GONE
                emoji.visibility = View.GONE
            } else {
                tvDay.text = day.toString()

                val diary = viewModel.getAllDiaryWithDay(year, month, day)?.also {
                    emoji.setImageResource(Utility.getResourceId(binding.root.context, it.mood))
                }

                container.setOnClickListener {

                }

                container.setOnLongClickListener(View.OnLongClickListener {
                    return@OnLongClickListener true
                })
            }
         }
    }
}