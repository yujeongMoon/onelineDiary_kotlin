package com.example.onelinediary_kotlin.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.R
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.adapter.SelectMoodAdapter
import com.example.onelinediary_kotlin.databinding.ActivityWriteNewDiaryBinding
import com.example.onelinediary_kotlin.dto.Mood
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel
import kotlin.properties.Delegates

class WriteNewDiaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteNewDiaryBinding

    // Delegates.notNull<Int>() : non-null, Int 타입도 가능
    private var selectedYear by Delegates.notNull<Int>()
    private var selectedMonth by Delegates.notNull<Int>()
    private var selectedDay by Delegates.notNull<Int>()

    private val diary = Diary()

    private var adapter: SelectMoodAdapter? = null

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWriteNewDiaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: DiaryViewModel by viewModels()

        intent?.also {
            selectedYear = it.getIntExtra("year", Utility.getYear())
            selectedMonth = it.getIntExtra("month", Utility.getMonth())
            selectedDay = it.getIntExtra("day", Utility.getDay())
        }

        if (adapter == null)
            adapter = SelectMoodAdapter(viewModel)
        binding.emojiSelectRecyclerview.layoutManager = LinearLayoutManager(this@WriteNewDiaryActivity, RecyclerView.HORIZONTAL, false)
        binding.emojiSelectRecyclerview.adapter = adapter

        with(binding) {

            todayDate.text = getString(R.string.reporting_date, selectedYear.toString(), selectedMonth.toString(), selectedDay.toString())

            photo.background = ContextCompat.getDrawable(applicationContext, R.drawable.default_placeholder_image)

            buttonLayout.setOnClickListener {
                with(diary) {
                    year = selectedYear
                    month = selectedMonth
                    day = selectedDay

                    contents = binding.diaryContents.text.toString()
                    mood = "love"
                }

                val intent = Intent().apply {
                    putExtra("changePosition", selectedYear * 12 + (selectedMonth - 1))
                }
                setResult(RESULT_OK, intent)
                viewModel.insertDiary(diary)
            }
        }

        viewModel.emojiStatus.observe(this) {
        }
    }
}