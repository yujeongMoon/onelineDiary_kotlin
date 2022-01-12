package com.example.onelinediary_kotlin.adapter.viewholder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.databinding.ViewholderMoodItemBinding
import com.example.onelinediary_kotlin.dialog.SelectDialog
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.MainViewModel
import java.util.*

class MainMoodViewHolder(private val binding: ViewholderMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val context = binding.root.context
    private var diary: Diary? = null

    fun onBind(year: Int, month: Int, day: Int, viewModel: MainViewModel) {
        with(binding) {
            if (day <= 0) {
                tvDay.visibility = View.GONE
                emoji.visibility = View.GONE
                container.setOnClickListener(null)
            } else {
                tvDay.visibility = View.VISIBLE
                emoji.visibility = View.VISIBLE

                tvDay.text = day.toString()

                diary = viewModel.getDiary(year, month, day).also {
                    emoji.setImageResource(Utility.getResourceId(context, it?.mood ?: "circle_gray"))
                }

                container.setOnClickListener {
                    if (Utility.isBeforeDay(year, month, day)) {
                        var className = "WriteNewDiaryActivity"
                        val intent = Intent().apply {
                            putExtra("year", year)
                            putExtra("month", month)
                            putExtra("day", day)

                            diary?.let {
                                className = "DetailDiaryActivity"
                            }

                            setClass(context, Class.forName("${context.packageName}.activity.${className}"))
                        }

//                        (context as MainActivity).launch(intent)
                        context.startActivity(intent)
                    }
                }

                container.setOnLongClickListener(View.OnLongClickListener {
                    diary?.let {
                      SelectDialog(
                          "${month}월 ${day}일의 일기를 삭제하겠습니까?",
                          "삭제",
                          "취소",
                          listener1 = { viewModel.deleteDiary(diary!!) },
                          null
                      ).show(context)
                    }

                    return@OnLongClickListener true
                })
            }
        }
    }
}