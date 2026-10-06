package com.seunome.habittracker.userinterface

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.seunome.habittracker.viewmodel.HabitoViewModel

@Composable
fun PerfilScreen(modifier: Modifier = Modifier, viewModel: HabitoViewModel, aoSair: () -> Unit) {
    Column(modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Seu Perfil", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Text("Continue firme nos seus treinos!")
        Spacer(Modifier.height(32.dp))
        OutlinedButton(onClick = aoSair) { Text("Sair da conta") }
    }
}
