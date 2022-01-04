package com.example.onelinediary_kotlin

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * DAO(Data Access Object) : 데이터에 접근할 수 있는 메소드를 정의해놓은 인터페이스
 * 인터페이스 또는 추상클래스로 생성한다.
 * Room 라이브러리를 통해 자동으로 api를 생성한다.
 */

@Dao
interface DiaryDao {
    // 테이블에 데이터 삽입
    @Insert
    fun insertDiary(diary: Diary)

    // 메소드를 호출하면 설정한 쿼리대로 동작
    @Query("SELECT * FROM Diary")
    fun getAllDiary() : LiveData<List<Diary>>

    // 메소드를 호출하면 설정한 쿼리대로 동작
    @Query("SELECT * FROM Diary WHERE year = :year")
    fun getAllDiaryWithYear(year: String) : List<Diary>
}