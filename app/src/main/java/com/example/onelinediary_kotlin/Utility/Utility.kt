package com.example.onelinediary_kotlin.Utility

import android.annotation.SuppressLint
import android.content.Context
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Utility {
    companion object {

        // 오늘 날짜를 원하는 포맷으로 반환한다.
        @SuppressLint("SimpleDateFormat")
        fun getToday(format: String) : String {
            return SimpleDateFormat(format).format(Date())
        }

        // 현재 연도
        @SuppressLint("SimpleDateFormat")
        fun getYearToString() : String {
            return SimpleDateFormat("yyyy").format(Date())
        }

        // 현재 달
        @SuppressLint("SimpleDateFormat")
        fun getMonthToString() : String {
            return SimpleDateFormat("MM").format(Date())
        }

        // 현재 일
        @SuppressLint("SimpleDateFormat")
        fun getDayToString() : String {
            return SimpleDateFormat("dd").format(Date())
        }

        // 현재 연도
        @SuppressLint("SimpleDateFormat")
        fun getYear() : Int {
            return Calendar.getInstance()[Calendar.YEAR]
        }

        // 현재 달
        // 인덱스가 0(1월)부터 시작하기 때문에 1을 더해준다
        @SuppressLint("SimpleDateFormat")
        fun getMonth() : Int {
            return Calendar.getInstance()[Calendar.MONTH] + 1
        }

        // 현재 일
        @SuppressLint("SimpleDateFormat")
        fun getDay() : Int {
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

        // 리소스 명을 입력하면 id를 반환한다.
        fun getResourceId(context: Context, res: String) : Int {
            return context.resources.getIdentifier(res, "drawable", context.packageName)
        }

        // 오늘 날짜와 비교하여 이전 날짜인지 결과 값을 반환
        // 이 전이면 true, 이 후이면 false
        @SuppressLint("SimpleDateFormat")
        fun isBeforeDay(year: Int, month: Int, day: Int) : Boolean {
            val dataFormat = SimpleDateFormat("yyyy년 M월 d일")

            val date1 = dataFormat.parse("${year}년 ${month}월 ${day}일")
            val date2 = dataFormat.parse(getToday("yyyy년 M월 d일"))

            return date1 <= date2
        }
    }
}