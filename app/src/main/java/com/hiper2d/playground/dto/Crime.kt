package com.hiper2d.playground.dto

import java.time.LocalDateTime
import java.util.*

class Crime {
    var title: String? = null
    var solved: Boolean = false
    val id: UUID = UUID.randomUUID()
    val date: LocalDateTime = LocalDateTime.now()
    var requiresPolice: Boolean = Random().nextInt(10).rem(5) == 0
}