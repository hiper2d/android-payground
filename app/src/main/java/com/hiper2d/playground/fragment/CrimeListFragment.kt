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
import com.hiper2d.playground.view.AbstractCrimeHolder
import com.hiper2d.playground.view.CrimeHolder
import com.hiper2d.playground.view.SeriousCrimeHolder
import kotlinx.android.synthetic.main.fragment_crime_list.view.*

class CrimeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_crime_list, container, false)
        .apply {
            crime_recycler_view.layoutManager = LinearLayoutManager(activity)
            updateUi(crime_recycler_view)
        }

    private fun updateUi(recyclerView: RecyclerView) {
        val crimeLab = CrimeLab.getInstance(activity!!)
        val crimes = crimeLab.crimes
        val adapter = CrimeAdapter(crimes)
        recyclerView.adapter = adapter
    }

    private inner class CrimeAdapter(private val crimes: List<Crime>): RecyclerView.Adapter<AbstractCrimeHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractCrimeHolder {
            val layoutInflater = LayoutInflater.from(activity)
            return when(viewType) {
                0 -> CrimeHolder(layoutInflater, parent)
                else -> SeriousCrimeHolder(layoutInflater, parent)
            }
        }

        override fun getItemCount(): Int = crimes.size

        override fun onBindViewHolder(holder: AbstractCrimeHolder, position: Int) {
            val crime = crimes[position]
            holder.bind(crime)
        }

        override fun getItemViewType(position: Int): Int {
            return if(crimes[position].requiresPolice) 1 else 0
        }
    }
}
