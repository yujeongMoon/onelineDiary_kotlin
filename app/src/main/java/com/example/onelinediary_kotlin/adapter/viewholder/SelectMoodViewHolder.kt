package com.example.onelinediary_kotlin.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.databinding.ViewholderSelectMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.DiaryViewModel

class SelectMoodViewHolder(private val binding: ViewholderSelectMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(position: Int, viewModel: DiaryViewModel) {
        val context = binding.root.context

        binding.emoji.setImageResource(Utility.getResourceId(context, viewModel.emojiStatus.value!![position].emoji))

        binding.emojiLayout.setOnClickListener {
            // 전체 리스트 초기화
            if (!viewModel.emojiStatus.value!![position].isChecked)
                viewModel.initEmojiStatus()

            viewModel.emojiStatus.value!![position].isChecked = viewModel.emojiStatus.value!![position].isChecked.not()

            binding.emojiSelect.visibility = if (viewModel.emojiStatus.value!![position].isChecked) View.VISIBLE else View.INVISIBLE
        }
    }
}