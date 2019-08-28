package com.hiper2d.playground.dto

import java.time.LocalDateTime
import java.util.*

class Crime {
    var title: String? = null
    var solved: Boolean = false
    val id: UUID = UUID.randomUUID()
    val date: LocalDateTime = LocalDateTime.now()
}