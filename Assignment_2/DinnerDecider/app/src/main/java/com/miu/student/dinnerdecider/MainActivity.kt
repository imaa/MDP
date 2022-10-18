package com.miu.student.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foodList = arrayListOf<String>("Hamburger","Pizza","Mexican","American","Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun decideClickEvent(view: View) {
        tvDecision.text = foodList[Random.nextInt(0,foodList.size-1)]
    }

    fun addFoodClickEvent(view: View) {
        if (etNewFood.text.isNotBlank())
        {
            foodList.add(etNewFood.text.toString())
            etNewFood.text.clear()
        }
    }
}