package com.example.onelinediary_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.adapter.viewholder.MainMoodViewHolder
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainMoodAdapter(private val year: Int, private val month: Int, private val diaryList: List<Diary>?) : RecyclerView.Adapter<MainMoodViewHolder>() {
    private val startDayInMonth = Utility.getDayOfWeek(year, month, 1) - 1

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMoodViewHolder {
        val mainMoodBinding = ViewholderMoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainMoodViewHolder(mainMoodBinding)
    }

    override fun onBindViewHolder(holder: MainMoodViewHolder, position: Int) {
        val day = (position - startDayInMonth) + 1

        if (diaryList != null) {
            for (diary in diaryList) {
                if (diary.day == day)
                    holder.onBind(day, diary)
                else
                    holder.onBind(day, null)
            }
        } else {
            holder.onBind(day, null)
        }
    }

    override fun getItemCount(): Int {
        return Utility.getCalenderItemCount(year, month)
    }
}