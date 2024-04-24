package com.example.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonLight = findViewById<Button>(R.id.btnLight)
        val layout = findViewById<LinearLayout>(R.id.linearLayout)

        buttonLight.setOnClickListener {
            // change the theme to light mode
            layout.setBackgroundResource(R.color.yellow)


        }

     buttonDark.setOnClickListener {
         layout.setBackgroundResource(R.color.black)

     }
    }
}