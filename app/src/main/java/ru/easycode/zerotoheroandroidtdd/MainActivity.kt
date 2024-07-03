package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var titleText: TextView
    lateinit var removeButton: Button
    lateinit var rootLayout: LinearLayout
    var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleText = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)
        rootLayout = findViewById(R.id.rootLayout)

        removeButton.setOnClickListener {
            state = State.Removed
            state.apply(titleText, rootLayout, removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("key", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("key") as State

        state.apply(titleText, rootLayout, removeButton)

    }
}

interface State: Serializable {

    fun apply(titleText: TextView, rootLayout: LinearLayout, removeButton: Button)

    object Initial: State {
        override fun apply(titleText: TextView, rootLayout: LinearLayout, removeButton: Button) = Unit
    }
    object Removed: State {
        override fun apply(titleText: TextView, rootLayout: LinearLayout, removeButton: Button) {
            rootLayout.removeView(titleText)
            removeButton.isEnabled = false
        }
    }
}