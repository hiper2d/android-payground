package com.hiper2d.playground.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hiper2d.playground.R
import com.hiper2d.playground.dto.Crime

class CrimeHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)) {

    private val title: TextView = itemView.findViewById(R.id.crime_title)
    private val date: TextView = itemView.findViewById(R.id.crime_date)

    fun bind(crime: Crime) {
        title.text = crime.title
        date.text = crime.date.toString()
    }
}

