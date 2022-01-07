package com.example.onelinediary_kotlin.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 테이블의 역할을 할 테이터 클래스
 * @Entity : SQLite 테이블을 의미
 * @PrimaryKey : 테이블의 기본키 설정
 * @ColumnInfo(name = "항목명") : 항목을 변수의 이름과 다르게 설정하고 싶을 때 사용
 */

@Entity(tableName = "Diary")
data class Diary(
    @ColumnInfo(name = "diary_id")
    @PrimaryKey(autoGenerate = true) val diaryId: Int?,
    val year: Int,
    val month: Int,
    val day: Int,
    val photo: String?,
    val contents: String?,
    val mood: String,
    val location: String?,
    val weather: String?
)