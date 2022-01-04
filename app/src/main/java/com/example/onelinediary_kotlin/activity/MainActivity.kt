package com.example.onelinediary_kotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel
import com.example.onelinediary_kotlin.adapter.MainPagerAdapter
import com.example.onelinediary_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.btnAddNewDiary.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, WriteNewDiaryActivity::class.java))
        })

        val mainPagerAdapter = MainPagerAdapter()
        mainBinding.pager.adapter = mainPagerAdapter

//        val model = ViewModelProvider(this).get(DiaryViewModel::class.java)
        // android KTX : 코틀린 확장 프로그램
        val model: DiaryViewModel by viewModels()

        model.allDiary?.observe(this, Observer<List<Diary>>() {
            mainPagerAdapter.setItem(it)
        })

    }
}