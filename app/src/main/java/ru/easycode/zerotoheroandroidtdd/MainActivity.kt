package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var titleText: TextView
    lateinit var hideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.titleTextView)
        hideButton = findViewById(R.id.hideButton)

        hideButton.setOnClickListener {
            titleText.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("visibility", titleText.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        titleText.visibility = savedInstanceState.getInt("visibility")
    }
}