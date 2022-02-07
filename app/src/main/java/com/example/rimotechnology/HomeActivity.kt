package com.example.rimotechnology

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        eye_hide.visibility = View.GONE

        val eyeshow = findViewById<ImageView>(R.id.eye_visible)
        val eyeHide = findViewById<ImageView>(R.id.eye_hide)

        eye_visible.setOnClickListener {
            moneyhide()
            eyeshow.visibility = View.GONE
            eyeHide.visibility = View.VISIBLE
            textView15.setText("Show Balance")
        }

        eyeHide.setOnClickListener {
            moneyvisible()
            eyeshow.visibility = View.VISIBLE
            eyeHide.visibility = View.GONE
            textView15.setText("Hide Balance")

        }

        }


    fun moneyhide(){
            money_value.setText("********")
    }


    fun moneyvisible(){
            money_value.setText("200,000")
    }
}