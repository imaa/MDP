package com.miu.student.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var Q1Answers: java.util.ArrayList<String>
    lateinit var Q2Answers: java.util.ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Q1Answers = resources.getStringArray(R.array.Q1Answers).toCollection(java.util.ArrayList())
        Q2Answers = resources.getStringArray(R.array.Q2Answers).toCollection(java.util.ArrayList())
        Q1A1.text = Q1Answers[0]
        Q1A2.text = Q1Answers[1]
        Q1A3.text = Q1Answers[2]
        Q2A1.text = Q2Answers[0]
        Q2A2.text = Q2Answers[1]
        Q2A3.text = Q2Answers[2]
        submit.setOnClickListener{
            var dialog = AlertDialog.Builder(this)
            dialog.setTitle("Quiz Result")
            var score = 0.0
            if (Q1A2.isChecked) {
                score += 50
            }
            if (Q2A1.isChecked && Q2A2.isChecked && !Q2A3.isChecked) {
                score += 50
            }else {
                if (Q2A1.isChecked) {
                    score += 25
                }
                if (Q2A2.isChecked) {
                    score += 25
                }
            }
            //get current date and time
            var date = Calendar.getInstance().time
            //format date and time
            var formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
            var formattedDate = formatter.format(date)
            dialog.setMessage("“Congratulations! You submitted on $formattedDate, and Your score is $score%")
            dialog.setPositiveButton("OK", null)
            dialog.show()

        }
        reset.setOnClickListener{
            Q1A1.isChecked = false
            Q1A2.isChecked = false
            Q1A3.isChecked = false
            Q2A1.isChecked = false
            Q2A2.isChecked = false
            Q2A3.isChecked = false
        }
    }
}