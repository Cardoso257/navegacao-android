package com.seunome.habittracker.model

data class Habito(
    val id: Int,
    val nome: String,
    val emoji: String,
    val meta: String,
    val concluidoHoje: Boolean = false
)
