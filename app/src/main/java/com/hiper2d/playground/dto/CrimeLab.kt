package com.hiper2d.playground.dto

import android.content.Context
import java.util.*

class CrimeLab private constructor(context: Context) {

    val crimes: List<Crime>

    companion object {
        private var INSTANCE: CrimeLab? = null

        fun getInstance(context: Context): CrimeLab {
            return INSTANCE ?: CrimeLab(context).apply { INSTANCE = this } // todo: make sure it works
        }
    }

    init {
        crimes = (1..100).map { i ->
            Crime().apply {
                this.title = "Crime #$i"
                this.solved = i.rem(2) == 0
            }
        }.toList()
    }

    fun getCrime(id: UUID) = crimes.find { it.id == id }
}