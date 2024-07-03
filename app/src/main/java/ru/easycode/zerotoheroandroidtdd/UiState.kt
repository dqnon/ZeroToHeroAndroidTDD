package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView

interface UiState {

    fun apply(countText: TextView, incrementButton: Button)

    data class Base(private val text: String): UiState {
        override fun apply(countText: TextView, incrementButton: Button) {
            countText.text = text
            incrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String): UiState {
        override fun apply(countText: TextView, incrementButton: Button) {
            countText.text = text
            incrementButton.isEnabled = false
        }
    }
}