package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {

    fun apply(countText: TextView,
              incrementButton: Button,
              decrementButton: Button
    )

    data class Min(private val text: String) : UiState {
        override fun apply(
            countText: TextView,
            incrementButton: Button,
            decrementButton: Button
        ) {
            countText.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
        }

    }

    data class Max(private val text: String) : UiState {
        override fun apply(
            countText: TextView,
            incrementButton: Button,
            decrementButton: Button
        ) {
            countText.text = text
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }

    }

    data class Base(private val text: String) : UiState {
        override fun apply(
            countText: TextView,
            incrementButton: Button,
            decrementButton: Button
        ) {
            countText.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
        }

    }


}