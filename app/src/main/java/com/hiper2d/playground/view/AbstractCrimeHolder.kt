package com.hiper2d.playground.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hiper2d.playground.dto.Crime
import kotlinx.android.synthetic.main.list_item_crime.view.*

abstract class AbstractCrimeHolder(
    viewId: Int,
    inflater: LayoutInflater,
    parent: ViewGroup
) : RecyclerView.ViewHolder(inflater.inflate(viewId, parent, false)) {

    init {
        itemView.setOnClickListener(ClickListener())
    }

    fun bind(crime: Crime) {
        itemView.crime_title.text = crime.title
        itemView.crime_date.text = crime.date.toString()
    }

    private inner class ClickListener: View.OnClickListener {
        override fun onClick(view: View) {
            Toast.makeText(view.context, itemView.crime_title.text, Toast.LENGTH_SHORT).show()
        }
    }
}