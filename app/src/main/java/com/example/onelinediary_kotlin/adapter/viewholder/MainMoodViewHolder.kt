package com.example.onelinediary_kotlin.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.R
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainMoodViewHolder(private val binding: ViewholderMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(day: Int, diary: Diary?) {
         with(binding) {
            if (day <= 0) {
                tvDay.visibility = View.GONE
                emoji.visibility = View.GONE
            } else {
                tvDay.text = day.toString()
                emoji.setImageResource(Utility.getResourceId(binding.root.context, diary?.mood ?: "circle_gray"))
            }
         }
    }
}