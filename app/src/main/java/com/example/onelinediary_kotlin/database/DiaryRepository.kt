package com.example.onelinediary_kotlin.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.onelinediary_kotlin.dao.DiaryDao
import com.example.onelinediary_kotlin.entity.Diary

/**
 * repository
 * 여러개의 데이터 소스(서버, DB)를 사용하기위해 만든 레이어
 * DAO는 전제 데이터베이스가 아닌 저장소의 생성자로 전달
 * DAO에 DB 접근 메소드가 있기 때문에 전체 데이터베이스를 노출할 필요없이 DAO만 접근한다.
 */
class DiaryRepository(database: DiaryDatabase) {
    companion object {
        private var instance: DiaryRepository? = null

        fun getInstance(context: Context) : DiaryRepository? {
            if (instance == null) {
                synchronized(DiaryRepository::class.java) {
                    instance = DiaryDatabase.getInstance(context)?.let { DiaryRepository(it) }
                }
            }
            return instance
        }
    }

    private val diaryDao: DiaryDao = database.diaryDao()

    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()

    fun getAllDiary(year: Int) : LiveData<List<Diary>> {
        return diaryDao.getAllDiary(year)
    }

    fun getAllDiary(year: Int, month: Int) : LiveData<List<Diary>> {
        return diaryDao.getAllDiary(year, month)
    }

    fun getDiary(year: Int, month: Int, day: Int) : Diary {
        return diaryDao.getDiary(year, month, day)
    }

    fun getDiaryWithLive(year: Int, month: Int, day: Int) : LiveData<Diary> {
        return diaryDao.getDiaryWithLive(year, month, day)
    }

    fun insertDiary(diary: Diary) {
        diaryDao.insertDiary(diary)
    }

    fun deleteDiary(diary: Diary) {
        diaryDao.deleteDiary(diary)
    }
}

//class DiaryRepository(private val diaryDao: DiaryDao) {
//    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()
//
//    fun insertDiary(diary: Diary) {
//        diaryDao.insertDiary(diary)
//    }
//}