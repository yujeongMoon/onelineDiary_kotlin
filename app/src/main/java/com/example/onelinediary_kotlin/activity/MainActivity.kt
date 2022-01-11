package com.example.onelinediary_kotlin.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.adapter.MainPagerAdapter
import com.example.onelinediary_kotlin.databinding.ActivityMainBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var adapter: MainPagerAdapter? = null

    private val refreshData = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            it.data?.also { position ->
                adapter?.notifyItemChanged(position.getIntExtra("changePosition", 0))
            }
        }
    }

    fun launch(intent: Intent) {
        refreshData.launch(intent)
    }

    private val viewModel: DiaryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (adapter == null)
            adapter = MainPagerAdapter(viewModel)
        binding.pager.adapter = adapter

        binding.pager.setCurrentItem(Utility.getYear() * 12 + (Utility.getMonth() - 1), false)

        binding.btnAddNewDiary.setOnClickListener {
            var className = "WriteNewDiaryActivity"

            val intent = Intent().apply {
                viewModel.getDiary(
                    Utility.getYear(),
                    Utility.getMonth(),
                    Utility.getDay()
                )?.let {
                    className = "DetailDiaryActivity"
                }

                setClass(this@MainActivity, Class.forName("${packageName}.activity.${className}"))
            }

//            refreshData.launch(intent)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val position = binding.pager.currentItem
        viewModel.getAllDiary(position.div(12), (position.rem(12)).plus(1))?.observe(this) {
            adapter?.notifyItemChanged(position, it)
        }

        viewModel.getTodayDiary?.observe(this) {
            it.also {
                binding.btnAddNewDiary.setImageResource(Utility.getResourceId(this, it?.mood ?: "add_circle"))
            }
        }
    }
}