package com.example.onelinediary_kotlin.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainMoodViewHolder(private val binding: ViewholderMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(position: Int, viewModel: DiaryViewModel) {
        val startDayInMonth = Utility.getDayOfWeek(
            viewModel.year.value?.toInt() ?: Utility.getYearToInt(),
            viewModel.month.value?.toInt() ?: 1,
            1
        ) - 1

         with(binding) {
            if (position < startDayInMonth) {
                tvDay.visibility = View.GONE
                emoji.visibility = View.GONE
            } else {
                val day = (position - startDayInMonth + 1).toString()
                tvDay.text = day
            }
         }
    }
}