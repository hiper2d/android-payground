package com.hiper2d.playground

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.hiper2d.playground.dto.Crime

class CrimeFragment: Fragment() {

    private lateinit var crime: Crime

    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_crime, container, false)
            .apply {
                setupTitleTextView(this)
                setupDateButton(this)
                setupSolvedCheckbox(this)
            }

    private fun setupTitleTextView(view: View) {
        titleField = view.findViewById(R.id.crime_title)
        titleField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }
        })
    }

    private fun setupDateButton(view: View) {
        dateButton = view.findViewById(R.id.crime_date)
        dateButton.text = crime.date.toString()
        dateButton.isEnabled = false
    }

    private fun setupSolvedCheckbox(view: View) {
        solvedCheckBox = view.findViewById(R.id.crime_solved)
        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.solved = isChecked
        }
    }
}