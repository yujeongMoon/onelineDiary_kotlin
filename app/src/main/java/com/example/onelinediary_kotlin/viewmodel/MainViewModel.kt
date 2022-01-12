package com.example.onelinediary_kotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onelinediary_kotlin.Utility.Utility
import com.example.onelinediary_kotlin.database.DiaryRepository
import com.example.onelinediary_kotlin.entity.Diary

/**
 * viewModel
 * application나 Activty, fragment 등의 lifecycleOwner의 수명주기를 고려하여 UI 관련 데이터를 저장하고 관리한다.
 * 화면 구성이 변겅되어도 데이터를 유지한다. ex) 화면 회전 등
 * 저장소와 UI 간의 통신센터의 역할을 한다.
 *
 * 추상클래스 ViewModel을 상속해서 viewModel 클래스를 생성한 경우, 직접 인스턴스 생성이 불가능하다.
 * viewModelProvider를 사용하여 viewModel 객체를 생성해야한다.
 * 1. 파라미터가 없는 경우 - lifecycleExtension
 * val model = ViewModelProvider(this).get(DiaryViewModel::class.java)
 * val model = ViewModelProvider(this)[DiaryViewModel::class.java]
 *
 * 2. 파라미터가 없는 경우 - ViewModelProvider.NewInstanceFactory(기본적으로 재공하는 팩토리 클래스)
 * val model = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(DiaryViewModel::class.java)
 *
 * 3. 파라미터가 있는 경우 - customFactory(ViewModelProvider.Factory를 직접 구현)
 * 아래의 방법을 사용하려면 application을 상속한 클래스를 만들어서 데이터 베이스와 저장소를 초기화 한 후
 * 팩토리를 사용하여 뷰모델 객체를 사용해야한다.
 * class DiaryViewModelFactory(private val repository: DiaryRepository) : ViewModelProvider.Factory {
 *   override fun <T : ViewModel> create(modelClass: Class<T>): T {
 *      if (modelClass.isAssignableFrom(DiaryViewModel::class.java)) {
 *          @Suppress("UNCHECKED_CAST")
 *          return DiaryViewModel(repository) as T
 *      }
 *      throw IllegalArgumentException("unKnown ViewModel class")
 *   }
 * }
 *
 * class DiaryViewModel(private val repository: DiaryRepository) : ViewModel() {
 *      val allDiary: LiveData<List<Diary>> = repository.allDiary
 *      fun insertDiary(diary: Diary) {
 *          repository.insertDiary(diary)
 *      }
 * }
 *
 * val model = ViewModelProvider(this, DiaryViewModelFactory(repository)).get(DiaryViewModel::class.java)
 *
 * 4. AndroidViewModel - ViewModel을 구현한 클래스
 * 일반적인 ViewModel은 Activity/Fragment의 lifecycle에 의존적인 뷰모델이고
 * AndroidViewModel은 application의 scope에 의존적인 뷰모델이다.
 * Activity/Fragment이 종료되어도 인스턴스가 유지되고 application이 종료되는 시점에 삭제된다.
 *
 * 확장 프로그램 Android KTX를 사용하여 간단하게 생성할 수 있다.
 * val model: DiaryViewModel by viewModels()
 *
 * repository를 사용하려면 커스텀 팩토리를 사용해서 뷰모델을 사용하거나 AndroidViewModel을 사용해야함?
 */

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = DiaryRepository.getInstance(application)

    val allDiary: LiveData<List<Diary>>? = repository?.allDiary

    fun getAllDiary(year: Int) : LiveData<List<Diary>>? {
        return repository?.getAllDiary(year)
    }

    fun getAllDiary(year: Int, month: Int) : LiveData<List<Diary>>? {
        return repository?.getAllDiary(year, month)
    }

    fun getDiary(year: Int, month: Int, day: Int) : Diary? {
        return repository?.getDiary(year, month, day)
    }

    fun getDiaryWithLive(year: Int, month: Int, day: Int) : LiveData<Diary>? {
        return repository?.getDiaryWithLive(year, month, day)
    }

    val getTodayDiary = getDiaryWithLive(Utility.getYear(), Utility.getMonth(), Utility.getDay())

    fun insertDiary(diary: Diary) {
        repository?.insertDiary(diary)
    }

    fun deleteDiary(diary: Diary) {
        repository?.deleteDiary(diary)
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
//}