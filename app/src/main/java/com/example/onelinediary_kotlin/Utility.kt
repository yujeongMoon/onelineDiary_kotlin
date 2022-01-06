package com.example.onelinediary_kotlin

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class Utility {
    companion object {

        // 현재 연도
        @SuppressLint("SimpleDateFormat")
        fun getYear() : String {
            return SimpleDateFormat("yyyy").format(Date())
        }

        // 현재 달
        @SuppressLint("SimpleDateFormat")
        fun getMonth() : String {
            return SimpleDateFormat("MM").format(Date())
        }

        // 현재 일
        @SuppressLint("SimpleDateFormat")
        fun getDay() : String {
            return SimpleDateFormat("dd").format(Date())
        }

        // 현재 연도
        @SuppressLint("SimpleDateFormat")
        fun getYearToInt() : Int {
            return Calendar.getInstance()[Calendar.YEAR]
        }

        // 현재 달
        // 인덱스가 0(1월)부터 시작하기 때문에 1을 더해준다
        @SuppressLint("SimpleDateFormat")
        fun getMonthToInt() : Int {
            return Calendar.getInstance()[Calendar.MONTH] + 1
        }

        // 현재 일
        @SuppressLint("SimpleDateFormat")
        fun getDayToInt() : Int {
            return Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        }

        // 입력한 달의 마지막 날짜
        fun getLastDayNumberOfMonth(year: Int, month: Int) : Int {
            val calender = Calendar.getInstance()
            calender.set(year, month - 1, 1)
            return calender.getActualMaximum(Calendar.DAY_OF_MONTH)
        }

        // 원하는 날짜의 요일(1: 일요일, ... 7: 토요일)
        fun getDayOfWeek(year: Int, month: Int, day: Int) : Int {
            val calender = Calendar.getInstance()
            calender.set(year, month - 1, day)
            return calender.get(Calendar.DAY_OF_WEEK)
        }

        // 일요일로 시작하는 달력에서 필요한 캘린더 아이템 개수를 반환한다.
        fun getCalenderItemCount(year: Int, month: Int) : Int {
            return getDayOfWeek(year, month, 1) - 1 + getLastDayNumberOfMonth(year, month)
        }
    }
}