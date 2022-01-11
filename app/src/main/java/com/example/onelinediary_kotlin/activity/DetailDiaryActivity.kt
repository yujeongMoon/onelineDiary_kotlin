package com.example.onelinediary_kotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onelinediary_kotlin.databinding.ActivityDetailDiaryBinding

class DetailDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}