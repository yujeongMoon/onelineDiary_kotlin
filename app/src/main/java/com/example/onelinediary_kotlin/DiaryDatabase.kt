package com.example.onelinediary_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

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
    abstract fun diaryDao() : DiaryDao

    companion object {
        private var instance: DiaryDatabase? = null

        fun getInstance(context: Context) : DiaryDatabase? {
            if (instance == null) {
                synchronized(DiaryDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DiaryDatabase::class.java,
                        "diary-database"
                    ).build()
                }
            }
            return instance
        }
    }
}