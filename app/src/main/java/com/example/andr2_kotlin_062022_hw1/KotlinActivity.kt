package com.example.andr2_kotlin_062022_hw1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// (Shift, Shift -> enter "kotlin" -> "Convert Java File to Kotlin File")
class KotlinActivity : AppCompatActivity() {
    private var plusBtn: Button? = null
    private var counterTextView: TextView? = null
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        initViews()
        setUniqueDecoration()
        plusBtn!!.setOnClickListener {
            counter++
            updateCounterTextView(counter)
        }
    }

    private fun setUniqueDecoration() {
        counterTextView!!.setTextColor(Color.BLUE)
    }

    private fun updateCounterTextView(counter: Int) {
        counterTextView!!.text = counter.toString()
    }

    private fun initViews() {
        plusBtn = findViewById(R.id.plus_btn)
        counterTextView = findViewById(R.id.counter_text_view)
    }
}