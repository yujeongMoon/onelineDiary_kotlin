package com.example.onelinediary_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.onelinediary_kotlin.database.DiaryRepository
import com.example.onelinediary_kotlin.entity.Diary

/**
 * viewModel
 * application나 Activty, fragment 등의 lifecycleOwner의 수명주기를 고려하여 UI 관련 데이터를 저장하고 관리한다.
 * 화면 구성이 변겅되어도 데이터를 유지한다. ex) 화면 회전 등
 * 저장소와 UI 간의 통신센터의 역할을 한다.
 */
class NewDiaryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DiaryRepository.getInstance(application)

    val emoji = com.example.onelinediary_kotlin.Mood.values()

    // TODO 일기가 변경되었는지 알 수있도록 플래그 생성

    val clickedEmoji = MutableLiveData<String>()

    fun insertDiary(diary: Diary) {
        repository?.insertDiary(diary)
    }
}
