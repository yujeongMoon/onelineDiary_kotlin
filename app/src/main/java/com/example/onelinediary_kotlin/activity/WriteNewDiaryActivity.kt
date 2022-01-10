package com.example.onelinediary_kotlin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.onelinediary_kotlin.R
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.databinding.ActivityWriteNewDiaryBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class WriteNewDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteNewDiaryBinding

    private var year: Int = Utility.getYearToInt()
    private var month: Int = Utility.getMonthToInt()
    private var day: Int = Utility.getDayToInt()

    private val diary: Diary = Diary()

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteNewDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val model: DiaryViewModel by viewModels()

        with(binding) {
            todayDate.text = getString(R.string.reporting_date, year.toString(), month.toString(), day.toString())

            photo.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_placeholder_image)

            buttonLayout.setOnClickListener {
                diary.year = year
                diary.month = month
                diary.day = day

                val contents = binding.diaryContents.text.toString()
                diary.contents = contents

                diary.mood = "love"

                model.setChangedPosition(year * 12 + (month - 1))
                model.insertDiary(diary)
            }
        }
    }
}