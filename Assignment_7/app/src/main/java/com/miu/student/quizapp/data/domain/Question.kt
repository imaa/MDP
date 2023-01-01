package com.miu.student.quizapp.data.domain

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "questions")
@TypeConverters(AnswerListConverter::class)
data class Question(@PrimaryKey(autoGenerate = true) var id: Int=0,
                    var text: String? ="", var answers: List<Answer>? =null,@Ignore var selectedAnswer: Answer?=null    ) :
    Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.createTypedArrayList(Answer),
        parcel.readParcelable(Answer::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(text)
        parcel.writeTypedList(answers)
        parcel.writeParcelable(selectedAnswer, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Question> {
        override fun createFromParcel(parcel: Parcel): Question {
            return Question(parcel)
        }

        override fun newArray(size: Int): Array<Question?> {
            return arrayOfNulls(size)
        }
    }
}
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