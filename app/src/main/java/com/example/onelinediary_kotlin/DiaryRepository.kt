package com.example.onelinediary_kotlin

import androidx.lifecycle.LiveData

/**
 * repository
 * 여러개의 데이터 소스(서버, DB)를 사용하기위해 만든 레이어
 * DAO는 전제 데이터베이스가 아닌 저장소의 생성자로 전달
 * DAO에 DB 접근 메소드가 있기 때문에 전체 데이터베이스를 노출할 필요없이 DAO만 접근한다.
 *
 * viewModel은 repository에 종속
 */
//class DiaryRepository(private val diaryDao: DiaryDao) {
//    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()
//
//    fun insertDiary(diary: Diary) {
//        diaryDao.insertDiary(diary)
//    }
//}

class DiaryRepository(database: DiaryDatabase) {
    private val diaryDao: DiaryDao = database.diaryDao();

    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()

    fun insertDiary(diary: Diary) {
        diaryDao.insertDiary(diary)
    }
}