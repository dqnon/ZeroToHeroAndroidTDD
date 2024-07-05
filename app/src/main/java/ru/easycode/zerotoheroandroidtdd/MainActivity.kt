package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val count = Count.Base(step = 2, max = 4, min = 0)
    private lateinit var uiState: UiState

    lateinit var countTextView: TextView
    lateinit var decrementButton: Button
    lateinit var incrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
         else
            savedInstanceState.getSerializable(KEY) as UiState

        uiState.apply(countTextView, incrementButton, decrementButton)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}

