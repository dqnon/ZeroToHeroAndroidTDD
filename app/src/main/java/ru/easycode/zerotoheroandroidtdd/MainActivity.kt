package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var changeButton: Button = findViewById(R.id.changeButton)
        var titleTextView: TextView = findViewById(R.id.titleTextView)

        changeButton.setOnClickListener {
            titleTextView.text = "I am an Android Developer!"
        }
    }
}