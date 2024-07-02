package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val KEY_MESSAGE = "messageKey"


    lateinit var titleTextView: TextView
    lateinit var changeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        changeButton = findViewById(R.id.changeButton)

        changeButton.setOnClickListener {
            titleTextView.text = "I am an Android Developer!"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(KEY_MESSAGE, titleTextView.text.toString())
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            titleTextView.text = savedInstanceState.getString(KEY_MESSAGE)
        }
    }
}