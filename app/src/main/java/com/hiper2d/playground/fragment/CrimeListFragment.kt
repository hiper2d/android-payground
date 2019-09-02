package com.hiper2d.playground.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hiper2d.playground.R

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
        }
}
