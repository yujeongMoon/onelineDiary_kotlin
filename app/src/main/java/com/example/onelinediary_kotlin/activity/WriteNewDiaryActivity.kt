package com.example.onelinediary_kotlin.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.onelinediary_kotlin.R
import com.example.onelinediary_kotlin.databinding.ActivityWriteNewDiaryBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel
import java.text.SimpleDateFormat
import java.util.*

class WriteNewDiaryActivity : AppCompatActivity() {
    private lateinit var newDiaryBinding: ActivityWriteNewDiaryBinding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newDiaryBinding = ActivityWriteNewDiaryBinding.inflate(layoutInflater)
        setContentView(newDiaryBinding.root)

        with(newDiaryBinding) {
            todayDate.text = SimpleDateFormat("yyyy년 MM월 dd일").format(Date())
            photo.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_placeholder_image)
        }

        val model: DiaryViewModel by viewModels()

        newDiaryBinding.buttonLayout.setOnClickListener {
            model.insertDiary(Diary(null, "2022", "01", "06", null, newDiaryBinding.diaryContents.text.toString(), "happy", null, null))
        }
    }
}