package com.example.onelinediary_kotlin

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onelinediary_kotlin.databinding.ViewholderMainDiaryBinding

class MainPagerAdapter : RecyclerView.Adapter<MainPagerViewHolder>(){
    private var items: List<Diary> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainPagerViewHolder {
        val mainPagerBinding = ViewholderMainDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainPagerViewHolder(mainPagerBinding)
    }

    override fun onBindViewHolder(holder: MainPagerViewHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItem(items: List<Diary>) {
        this.items = items
        this.notifyDataSetChanged()
    }
}