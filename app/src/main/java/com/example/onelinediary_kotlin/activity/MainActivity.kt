package com.example.onelinediary_kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.onelinediary_kotlin.Utility
import com.example.onelinediary_kotlin.adapter.MainPagerAdapter
import com.example.onelinediary_kotlin.databinding.ActivityMainBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: MainPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // android KTX : 코틀린 확장 프로그램
        val viewModel: DiaryViewModel by viewModels()

        if (adapter == null)
            adapter = MainPagerAdapter(this, viewModel)
        binding.pager.adapter = adapter

        binding.pager.currentItem = Utility.getYearToInt() * 12 + (Utility.getMonthToInt() - 1)

        viewModel.changedPosition.observe(this) {
            if (it != 0)
                adapter?.notifyItemChanged(it)
        }

        binding.btnAddNewDiary.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, WriteNewDiaryActivity::class.java))
        })
    }
}