package com.miu.student.quizapp.data.domain

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
@Entity(tableName = "answers", foreignKeys = [ForeignKey(entity = Question::class, parentColumns = ["id"], childColumns = ["questionId"], onDelete = ForeignKey.CASCADE)])
data class Answer( @PrimaryKey(autoGenerate = true) val  id: Int=0 ,val text:String=""  , val isCorrect:Boolean=false,val questionId: Int=0 )