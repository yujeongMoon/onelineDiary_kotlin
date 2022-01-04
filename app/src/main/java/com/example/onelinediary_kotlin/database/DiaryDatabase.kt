package com.example.onelinediary_kotlin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.onelinediary_kotlin.dao.DiaryDao
import com.example.onelinediary_kotlin.entity.Diary

/**
 * roomDatabase
 * 데이터베이스를 생성하고 관리하는 객체를 생성
 * entities : 한 개체 역할을 할 데이터 클래스
 * 여러개의 entity가 필요한 경우, 리스트로 값을 설정
 * version : entity의 구조를 변경해야할 때, 이전의 값과 구분해주는 역할
 * 구조가 바뀌었는데 버전이 같다면 에러발생
 */
@Database(entities = [Diary::class], version = 1)
abstract class DiaryDatabase : RoomDatabase() {
    // 데이터베이스와 연결되는 DAO
    abstract fun diaryDao() : DiaryDao

    companion object {
        // 싱글턴패턴으로 데이터베이스 객제 중복 방지
        private var instance: DiaryDatabase? = null

        fun getInstance(context: Context) : DiaryDatabase? {
            if (instance == null) {
                // 동시에 두개의 인스턴스 생성으로 막기 위한 synchronized
                synchronized(DiaryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDatabase::class.java,
                        "diary-database"
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}