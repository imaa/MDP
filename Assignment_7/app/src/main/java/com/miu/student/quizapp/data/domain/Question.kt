package com.miu.student.quizapp.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "questions")
@TypeConverters(AnswerListConverter::class)
data class Question (@PrimaryKey(autoGenerate = true)   val id: Int=0,val text:String="", val answers: List<Answer>? =null)
class AnswerListConverter {
    @TypeConverter
    fun fromString(value: String): List<Answer> {
        val listType = object : TypeToken<List<Answer>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Answer>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}