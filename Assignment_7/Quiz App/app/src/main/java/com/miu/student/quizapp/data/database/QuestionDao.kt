package com.miu.student.quizapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.miu.student.quizapp.data.domain.Question

@Dao
interface QuestionDao {
    @Query("SELECT * FROM questions")
    fun getAll(): List<Question>

    @Insert
    fun insert(question: Question)

    @Delete
    fun delete(question: Question)
}