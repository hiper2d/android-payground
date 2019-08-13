package com.hiper2d.androidplayground

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.hiper2d.androidplayground.dto.Question

import kotlinx.android.synthetic.main.activity_main.*

private val QUESTIONS = listOf(
    Question(R.string.question_1, true),
    Question(R.string.question_2, true),
    Question(R.string.question_3, false)
)

class MainActivity : AppCompatActivity() {

    private lateinit var bYes: Button
    private lateinit var bNo: Button
    private lateinit var bNext: Button
    private lateinit var bPrev: Button
    private lateinit var tvQuestion: TextView

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bNext = findViewById(R.id.button_next)
        bPrev = findViewById(R.id.button_prev)
        bYes = findViewById(R.id.button_yes)
        bNo = findViewById(R.id.button_no)
        tvQuestion = findViewById(R.id.text_question)

        tvQuestion.setText(QUESTIONS[currentQuestionIndex].textResId)
        bYes.setOnClickListener { checkAnswer(true) }
        bNo.setOnClickListener { checkAnswer(false) }
        bNext.setOnClickListener { showNextQuestion() }
        bPrev.setOnClickListener { showPrevQuestion() }

        bPrev.isEnabled = false

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Nothing is here yet", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun showPrevQuestion() {
        if (currentQuestionIndex > 1) {
            tvQuestion.setText(QUESTIONS[--currentQuestionIndex].textResId)
            enableAll()
        } else {
            bPrev.isEnabled = false
        }
    }

    private fun showNextQuestion() {
        if (currentQuestionIndex < QUESTIONS.lastIndex) {
            tvQuestion.setText(QUESTIONS[++currentQuestionIndex].textResId)
            enableAll()
        } else {
            showToast(R.string.answer_congrats)
            listOf(bNext, bYes, bNo).forEach { it.isEnabled = false }
        }
    }

    private fun showToast(textId: Int) {
        Toast.makeText(this, textId, Toast.LENGTH_SHORT).show()
    }

    private fun checkAnswer(answer: Boolean) {
        if (answer == QUESTIONS[currentQuestionIndex].answer) {
            showToast(R.string.answer_correct)
            showNextQuestion()
        } else {
            showToast(R.string.answer_incorrect)
        }
    }

    private fun enableAll() {
        listOf(bPrev, bNext, bYes, bNo).forEach { it.isEnabled = true }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
