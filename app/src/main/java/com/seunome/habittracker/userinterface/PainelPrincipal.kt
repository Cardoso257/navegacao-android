package com.seunome.habittracker.userinterface

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.seunome.habittracker.model.Rota
import com.seunome.habittracker.viewmodel.HabitoViewModel

enum class AbaPrincipal { HABITOS, ESTATISTICAS, PERFIL }

@Composable
fun PainelPrincipal(navController: NavHostController, viewModel: HabitoViewModel, abaAtual: AbaPrincipal) {
    Scaffold(bottomBar = {
        NavigationBar {
            NavigationBarItem(
                selected = abaAtual == AbaPrincipal.HABITOS,
                onClick = { navegarParaAba(navController, Rota.ListaHabitos) },
                icon = { Icon(Icons.Filled.CheckCircle, contentDescription = "Treinos") },
                label = { Text("Treinos") }
            )
            NavigationBarItem(
                selected = abaAtual == AbaPrincipal.ESTATISTICAS,
                onClick = { navegarParaAba(navController, Rota.Estatisticas) },
                icon = { Icon(Icons.Filled.BarChart, contentDescription = "Estatísticas") },
                label = { Text("Estatísticas") }
            )
            NavigationBarItem(
                selected = abaAtual == AbaPrincipal.PERFIL,
                onClick = { navegarParaAba(navController, Rota.Perfil) },
                icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
                label = { Text("Perfil") }
            )
        }
    }) { paddingValues ->
        when (abaAtual) {
            AbaPrincipal.HABITOS -> ListaHabitosScreen(Modifier.padding(paddingValues), viewModel) { id ->
                navController.navigate(Rota.DetalheHabito(id))
            }
            AbaPrincipal.ESTATISTICAS -> EstatisticasScreen(Modifier.padding(paddingValues), viewModel)
            AbaPrincipal.PERFIL -> PerfilScreen(Modifier.padding(paddingValues), viewModel) {
                viewModel.fazerLogout()
                navController.navigate(Rota.Login) { popUpTo(0) { inclusive = true } }
            }
        }
    }
}

private fun navegarParaAba(navController: NavHostController, destino: Rota) {
    navController.navigate(destino) {
        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}
