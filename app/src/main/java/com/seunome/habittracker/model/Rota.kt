package com.seunome.habittracker.model

import kotlinx.serialization.Serializable

sealed interface Rota {
    @Serializable data object Splash : Rota
    @Serializable data object Login : Rota
    @Serializable data object ListaHabitos : Rota
    @Serializable data object Estatisticas : Rota
    @Serializable data object Perfil : Rota
    @Serializable data class DetalheHabito(val habitoId: Int) : Rota
}
