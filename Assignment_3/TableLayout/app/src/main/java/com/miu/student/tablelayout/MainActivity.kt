package com.miu.student.tablelayout

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add.setOnClickListener {
            var newRow =TableRow(applicationContext)
            newRow.setBackgroundColor( resources.getColor(R.color.row_body))
            var  newVersion = TextView(applicationContext)
            newVersion.text = version.text;
            newVersion.background=resources.getDrawable(R.drawable.border)
            newVersion.setPadding(5,5,5,5)
            newVersion.setTypeface(newVersion.typeface, Typeface.BOLD);
            newVersion.setTextColor(Color.BLACK)

            var  newName = TextView(applicationContext)
            newName.text = name.text
            newName.background=resources.getDrawable(R.drawable.border)
            newName.setPadding(5,5,5,5)
            newName.setTypeface(newName.typeface, Typeface.BOLD);
            newName.setTextColor(Color.BLACK)
            newRow.addView(newVersion)
            newRow.addView(newName)
            tableLayout.addView(newRow)
        }
    }
}