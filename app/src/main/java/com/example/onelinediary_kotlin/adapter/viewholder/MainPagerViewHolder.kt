package com.example.onelinediary_kotlin.adapter.viewholder

import android.annotation.SuppressLint
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.adapter.MainMoodAdapter
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding
import com.example.onelinediary_kotlin.entity.Diary
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class MainPagerViewHolder(private val binding: ViewholderMainDiaryBinding, private val viewModel: DiaryViewModel)
    : RecyclerView.ViewHolder(binding.root) {

    private lateinit var gestureDetector: GestureDetector

    fun onBind() {
        with(binding) {
            year.text = viewModel.year.value.toString()
            month.text = viewModel.month.value.toString()

            moodLayout.layoutManager = GridLayoutManager(binding.root.context, 7)
            val mainMoodAdapter = MainMoodAdapter(viewModel)
            moodLayout.adapter = mainMoodAdapter

//            gestureDetector = GestureDetector(root.context, SingleTapGestureListener(viewModel))
//            container.setOnTouchListener { view, event ->
//                gestureDetector.onTouchEvent(event)
//                false
//            }
        }
    }
}

//class SingleTapGestureListener(private val viewModel: DiaryViewModel) : SimpleOnGestureListener() {
//    override fun onFling(
//        e1: MotionEvent?,
//        e2: MotionEvent?,
//        velocityX: Float,
//        velocityY: Float
//    ): Boolean {
////        return super.onFling(e1, e2, velocityX, velocityY)
//        if (velocityX > 0) { // 이전 달로 이동
//            if (viewModel.month.value == 1) {
//                viewModel.year.value = viewModel.year.value?.minus(1)
//                viewModel.month.value = 12
//            } else {
//                viewModel.month.value = viewModel.month.value?.minus(1)
//            }
//        } else { // 다음달로 이동
//            if (viewModel.month.value == 12) {
//                viewModel.year.value = viewModel.year.value?.plus(1)
//                viewModel.month.value = 1
//            } else {
//                viewModel.month.value = viewModel.month.value?.plus(1)
//            }
//        }
//        return true
//    }
//}