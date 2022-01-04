package com.example.onelinediary_kotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class DiaryViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DiaryDatabase.getInstance(application)?.let { DiaryRepository(it) }

    val allDiary: LiveData<List<Diary>>? = repository?.allDiary

    fun insertDiary(diary: Diary) {
        repository?.insertDiary(diary)
    }
}

//class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {
//    val allDiary: LiveData<List<Diary>> = repository.allDiary
//
//    fun insertDiary(diary: Diary) {
//        repository.insertDiary(diary)
//    }
//}

//class DiaryViewModelFactory(private val repository: DiaryRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return DiaryViewModel(repository) as T
//        }
//        throw IllegalArgumentException("unKnown ViewModel class")
//    }
//
//}