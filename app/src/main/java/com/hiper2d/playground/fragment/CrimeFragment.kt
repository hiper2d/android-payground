package com.hiper2d.playground.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hiper2d.playground.R
import com.hiper2d.playground.dto.Crime
import kotlinx.android.synthetic.main.fragment_crime.*

class CrimeFragment: Fragment() {

    private val crime: Crime by lazy { Crime() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_crime, container, false)
            .apply {
                setupTitleTextView()
                setupDateButton()
                setupSolvedCheckbox()
            }

    private fun setupTitleTextView() {
        crime_title.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }
        })
    }

    private fun setupDateButton() {
        crime_date.text = crime.date.toString()
        crime_date.isEnabled = false
    }

    private fun setupSolvedCheckbox() {
        crime_solved.setOnCheckedChangeListener { _, isChecked ->
            crime.solved = isChecked
        }
    }
}