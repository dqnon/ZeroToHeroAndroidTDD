package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var countTextView: TextView
    lateinit var incrementButton: Button

    private val count: Count = Count.Base(step = 2, max = 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            val state = count.increment(countTextView.text.toString())
            state.apply(countTextView, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("button", incrementButton.isEnabled)
        outState.putString("count", countTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        incrementButton.isEnabled = savedInstanceState.getBoolean("button")
        countTextView.text = savedInstanceState.getString("count")
    }
}