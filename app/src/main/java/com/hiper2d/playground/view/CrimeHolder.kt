package com.hiper2d.playground.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hiper2d.playground.R
import com.hiper2d.playground.dto.Crime
import kotlinx.android.synthetic.main.list_item_crime.view.*

class CrimeHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item_crime, parent, false)), View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        Toast.makeText(view.context, itemView.crime_title.text, Toast.LENGTH_SHORT).show()
    }

    fun bind(crime: Crime) {
        itemView.crime_title.text = crime.title
        itemView.crime_date.text = crime.date.toString()
    }
}

