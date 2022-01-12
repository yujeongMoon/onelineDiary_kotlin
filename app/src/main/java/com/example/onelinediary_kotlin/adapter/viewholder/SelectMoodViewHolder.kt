package com.example.onelinediary_kotlin.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.adapter.SelectMoodAdapter
import com.example.onelinediary_kotlin.databinding.ViewholderSelectMoodItemBinding
import com.example.onelinediary_kotlin.viewmodel.NewDiaryViewModel

class SelectMoodViewHolder(private val adapter: SelectMoodAdapter, private val binding: ViewholderSelectMoodItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(position: Int, viewModel: NewDiaryViewModel) {
        val context = binding.root.context

        val emoji = viewModel.emoji[position].name.lowercase()
        binding.emoji.setImageResource(Utility.getResourceId(context, emoji))

        binding.emojiSelect.visibility = if (viewModel.clickedEmoji.value == emoji) View.VISIBLE else View.INVISIBLE

        binding.emojiLayout.setOnClickListener {
            viewModel.clickedEmoji.value = if (viewModel.clickedEmoji.value != emoji) emoji else ""
        }
    }
}