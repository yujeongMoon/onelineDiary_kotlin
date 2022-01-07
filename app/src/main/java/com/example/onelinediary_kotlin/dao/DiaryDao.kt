package com.example.onelinediary_kotlin.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.onelinediary_kotlin.entity.Diary
import java.time.Month

/**
 * DAO(Data Access Object) : 데이터에 접근할 수 있는 메소드를 정의해놓은 인터페이스
 * 인터페이스 또는 추상클래스로 생성한다.
 * Room 라이브러리를 통해 자동으로 api를 생성한다.
 */

@Dao
interface DiaryDao {
    // 테이블에 데이터 삽입
    // 작성한 일기를 DB에 저장한다.
    @Insert
    fun insertDiary(diary: Diary)

    // 메소드를 호출하면 설정한 쿼리대로 동작
    // 작성한 일기 전체를 가져온다.
    @Query("SELECT * FROM Diary")
    fun getAllDiary() : LiveData<List<Diary>>

    // 입력한 연도의 일기들만 불러온다.
    @Query("SELECT * FROM Diary WHERE year = :year")
    fun getAllDiaryWithYear(year: Int) : LiveData<List<Diary>>

    @Query("SELECT * FROM Diary WHERE year = :year AND month = :month")
    fun getAllDiaryWithMonth(year: Int, month: Int) : LiveData<List<Diary>>

    @Query("SELECT * FROM Diary WHERE year = :year AND month = :month AND day = :day")
    fun getAllDiaryWithDay(year: Int, month: Int, day: Int) : LiveData<Diary>

    //TODO 월단위 / 일단위로 일기 가져오는 기능, 일기 수정, 삭제 기능 필요
}