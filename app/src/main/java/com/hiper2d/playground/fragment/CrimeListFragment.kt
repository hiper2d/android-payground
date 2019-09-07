package com.hiper2d.playground.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiper2d.playground.R
import com.hiper2d.playground.dto.Crime
import com.hiper2d.playground.dto.CrimeLab
import com.hiper2d.playground.view.CrimeHolder

class CrimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_crime_list, container, false)
        .apply {
            recyclerView = this.findViewById(R.id.crime_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            updateUi()
        }

    private fun updateUi() {
        val crimeLab = CrimeLab.getInstance(activity!!)
        val crimes = crimeLab.crimes
        val adapter = CrimeAdapter(crimes)
        recyclerView.adapter = adapter
    }

    inner class CrimeAdapter(private val crimes: List<Crime>): RecyclerView.Adapter<CrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
            val layoutInflater = LayoutInflater.from(activity)
            return CrimeHolder(layoutInflater, parent)
        }

        override fun getItemCount(): Int = crimes.size

        override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
            val crime = crimes[position]
            holder.bind(crime)
        }
    }
}
