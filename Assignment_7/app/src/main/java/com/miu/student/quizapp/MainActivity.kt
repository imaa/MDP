package com.miu.student.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.student.quizapp.data.QuestionsHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QuestionsHelper.initQuestions()
    }
}