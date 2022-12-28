package com.miu.student.quizapp

import android.app.Application
import com.miu.student.quizapp.data.database.AppDatabase

class QuizApp :Application() {
    companion object{
        lateinit var database: AppDatabase
            private set
    }
    override fun onCreate() {
        super.onCreate()
        database = AppDatabase.getInstance(this)
    }
}