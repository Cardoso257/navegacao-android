package com.seunome.habittracker.userinterface

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seunome.habittracker.model.Habito

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalheHabitoScreen(habito: Habito?, aoVoltar: () -> Unit, aoAlternarConclusao: () -> Unit) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(habito?.nome ?: "Treino") },
            navigationIcon = { IconButton(onClick = aoVoltar) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Voltar")
            } }
        )
    }) { padding ->
        if (habito == null) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Treino não encontrado.")
            }
            return@Scaffold
        }
        Column(Modifier.fillMaxSize().padding(padding).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(habito.emoji, fontSize = 72.sp)
            Spacer(Modifier.height(16.dp))
            Text(habito.nome, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text("Meta: ${habito.meta}", style = MaterialTheme.typography.bodyLarge)
            Spacer(Modifier.height(32.dp))
            Button(onClick = aoAlternarConclusao) {
                Text(if (habito.concluidoHoje) "Desmarcar conclusão" else "Marcar como concluído hoje")
            }
        }
    }
}
