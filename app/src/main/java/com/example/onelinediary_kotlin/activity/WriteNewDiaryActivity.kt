package com.example.onelinediary_kotlin.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.onelinediary_kotlin.Diary
import com.example.onelinediary_kotlin.DiaryViewModel
import com.example.onelinediary_kotlin.databinding.ActivityWriteNewDiaryBinding

class WriteNewDiaryActivity : AppCompatActivity() {
    private lateinit var newDiaryBinding: ActivityWriteNewDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newDiaryBinding = ActivityWriteNewDiaryBinding.inflate(layoutInflater)
        setContentView(newDiaryBinding.root)

        val model: DiaryViewModel by viewModels()

        newDiaryBinding.buttonLayout.setOnClickListener {
            model.insertDiary(Diary(null, "2022", "02", "04", null, null, "happy", null, null))
        }
    }
}