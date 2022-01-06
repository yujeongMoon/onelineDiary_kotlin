package com.example.onelinediary_kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.onelinediary_kotlin.adapter.MainPagerAdapter
import com.example.onelinediary_kotlin.databinding.ActivityMainBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainPagerAdapter: MainPagerAdapter

    // android KTX : 코틀린 확장 프로그램
    private val viewModel: DiaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainPagerAdapter = MainPagerAdapter(viewModel)
        mainBinding.pager.adapter = mainPagerAdapter

//        mainBinding.pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            var scrollState = 0
//            var targetPage = 0;
//            var prevPage = mainBinding.pager.currentItem;
//
//            override fun onPageScrollStateChanged(state: Int) {
//                super.onPageScrollStateChanged(state)
//                if (state == ViewPager.SCROLL_STATE_SETTLING)
//                    prevPage = targetPage
//                scrollState = state
//            }
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                if (prevPage < position) {
//                    viewModel.month.value = viewModel.month.value?.plus(1)
//                } else {
//                    viewModel.month.value = viewModel.month.value?.minus(1)
//                }
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//
//                targetPage = position
//
//            }
//        })

        viewModel.getAllDiaryWithMonth(viewModel.year.value!!, viewModel.month.value!!)?.observe(this, Observer<List<Diary>>() {
            Log.d("Mainssss", "change!")
        })

        mainBinding.btnAddNewDiary.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, WriteNewDiaryActivity::class.java))
        })
    }
}