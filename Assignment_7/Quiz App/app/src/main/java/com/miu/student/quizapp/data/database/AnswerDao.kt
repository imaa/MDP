package com.miu.student.quizapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.miu.student.quizapp.data.domain.Answer

@Dao
interface AnswerDao {
    @Query("SELECT * FROM answers WHERE questionId = :questionId")
    fun getAnswersForQuestion(questionId: Int): List<Answer>

    @Insert
    fun insert(answer: Answer)

    @Delete
    fun delete(answer: Answer)
}