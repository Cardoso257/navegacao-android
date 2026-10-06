package com.seunome.habittracker.userinterface

import androidx.compose.foundation.layout.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.seunome.habittracker.viewmodel.HabitoViewModel

@Composable
fun EstatisticasScreen(modifier: Modifier = Modifier, viewModel: HabitoViewModel) {
    val total = viewModel.habitos.size
    val concluidos = viewModel.habitos.count { it.concluidoHoje }
    val progresso = if (total == 0) 0f else concluidos.toFloat() / total

    Column(modifier.fillMaxSize().padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Progresso de hoje", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(24.dp))
        Text("$concluidos de $total treinos concluídos", style = MaterialTheme.typography.bodyLarge)
        Spacer(Modifier.height(16.dp))
        LinearProgressIndicator(progress = { progresso }, modifier = Modifier.fillMaxWidth().height(10.dp))
    }
}
