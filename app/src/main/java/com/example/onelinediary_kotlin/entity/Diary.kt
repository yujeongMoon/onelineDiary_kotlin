package com.example.onelinediary_kotlin.entity

import android.os.Parcel
import android.os.Parcelable
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
    @PrimaryKey(autoGenerate = true) val diaryId: Int? = null,
    var year: Int = 0,
    var month: Int = 0,
    var day: Int = 0,
    var photo: String? = null,
    var contents: String? = null,
    var mood: String = "none",
    var location: String? = null,
    var weather: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(diaryId)
        parcel.writeInt(year)
        parcel.writeInt(month)
        parcel.writeInt(day)
        parcel.writeString(photo)
        parcel.writeString(contents)
        parcel.writeString(mood)
        parcel.writeString(location)
        parcel.writeString(weather)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Diary> {
        override fun createFromParcel(parcel: Parcel): Diary {
            return Diary(parcel)
        }

        override fun newArray(size: Int): Array<Diary?> {
            return arrayOfNulls(size)
        }
    }
}