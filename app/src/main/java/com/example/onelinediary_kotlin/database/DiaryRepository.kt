package com.example.onelinediary_kotlin.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.onelinediary_kotlin.dao.DiaryDao
import com.example.onelinediary_kotlin.database.DiaryDatabase
import com.example.onelinediary_kotlin.entity.Diary
import java.time.Month

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

    private val diaryDao: DiaryDao = database.diaryDao();

    val changedPosition = MutableLiveData<Int>().apply {
        value = 0
    }

    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()

    fun getAllDiaryWithYear(year: Int) : LiveData<List<Diary>> {
        return diaryDao.getAllDiaryWithYear(year)
    }

    fun getAllDiaryWithMonth(year: Int, month: Int) : List<Diary> {
        return diaryDao.getAllDiaryWithMonth(year, month)
    }

    fun getAllDiaryWithDay(year: Int, month: Int, day: Int) : Diary {
        return diaryDao.getAllDiaryWithDay(year, month, day)
    }

    fun insertDiary(diary: Diary) {
        diaryDao.insertDiary(diary)
    }
}

//class DiaryRepository(private val diaryDao: DiaryDao) {
//    val allDiary: LiveData<List<Diary>> = diaryDao.getAllDiary()
//
//    fun insertDiary(diary: Diary) {
//        diaryDao.insertDiary(diary)
//    }
//}