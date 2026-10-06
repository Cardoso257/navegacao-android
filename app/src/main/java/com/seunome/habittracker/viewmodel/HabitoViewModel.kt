package com.seunome.habittracker.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.seunome.habittracker.model.Habito

class HabitoViewModel : ViewModel() {
    var estaLogado by mutableStateOf(false)
        private set

    val habitos = mutableStateListOf(
        Habito(1, "Corrida", "🏃", "30 minutos"),
        Habito(2, "Musculação", "🏋️", "45 minutos"),
        Habito(3, "Alongamento", "🧘", "15 minutos"),
        Habito(4, "Caminhada", "🚶", "5.000 passos")
    )

    fun fazerLogin() { estaLogado = true }
    fun fazerLogout() { estaLogado = false }

    fun alternarConclusao(habitoId: Int) {
        val index = habitos.indexOfFirst { it.id == habitoId }
        if (index >= 0) {
            habitos[index] = habitos[index].copy(concluidoHoje = !habitos[index].concluidoHoje)
        }
    }

    fun buscarHabito(habitoId: Int): Habito? = habitos.find { it.id == habitoId }
}
