package com.seunome.habittracker.userinterface

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.seunome.habittracker.model.Rota
import com.seunome.habittracker.viewmodel.HabitoViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: HabitoViewModel = viewModel()

    NavHost(navController = navController, startDestination = Rota.Splash) {
        composable<Rota.Splash> {
            SplashScreen(viewModel.estaLogado) { logado ->
                val destino = if (logado) Rota.ListaHabitos else Rota.Login
                navController.navigate(destino) { popUpTo(Rota.Splash) { inclusive = true } }
            }
        }
        composable<Rota.Login> {
            LoginScreen {
                viewModel.fazerLogin()
                navController.navigate(Rota.ListaHabitos) { popUpTo(Rota.Login) { inclusive = true } }
            }
        }
        composable<Rota.ListaHabitos> { PainelPrincipal(navController, viewModel, AbaPrincipal.HABITOS) }
        composable<Rota.Estatisticas> { PainelPrincipal(navController, viewModel, AbaPrincipal.ESTATISTICAS) }
        composable<Rota.Perfil> { PainelPrincipal(navController, viewModel, AbaPrincipal.PERFIL) }
        composable<Rota.DetalheHabito> { backStackEntry ->
            val rota: Rota.DetalheHabito = backStackEntry.toRoute()
            DetalheHabitoScreen(
                habito = viewModel.buscarHabito(rota.habitoId),
                aoVoltar = { navController.popBackStack() },
                aoAlternarConclusao = { viewModel.alternarConclusao(rota.habitoId) }
            )
        }
    }
}
