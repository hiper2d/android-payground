package com.hiper2d.androidplayground

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class CheatActivity : AppCompatActivity() {

    private lateinit var tvAnswer: TextView
    private lateinit var bCheat: Button

    private var isCheated = false

    companion object {
        const val EXTRA_ANSWER_IS_TRUE = "EXTRA_ANSWER_IS_TRUE"
        const val EXTRA_ANSWER_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)
        val answer = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        tvAnswer = findViewById(R.id.text_view_answer)
        bCheat = findViewById(R.id.button_cheat)

        bCheat.setOnClickListener {
            isCheated = true
            tvAnswer.setText(if (answer) R.string.button_true else R.string.button_false)
        }

        setResult(EXTRA_ANSWER_CODE, Intent().putExtra(EXTRA_ANSWER_IS_TRUE, isCheated))
    }
}
