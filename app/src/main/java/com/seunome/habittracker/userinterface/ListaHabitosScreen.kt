package com.seunome.habittracker.userinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seunome.habittracker.model.Habito
import com.seunome.habittracker.viewmodel.HabitoViewModel

@Composable
fun ListaHabitosScreen(
    modifier: Modifier = Modifier,
    viewModel: HabitoViewModel,
    aoAbrirDetalhe: (Int) -> Unit
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text("Treinos de hoje", style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
        Text("Toque em um treino para ver os detalhes", modifier = Modifier.padding(horizontal = 20.dp))
        Spacer(Modifier.height(12.dp))

        if (viewModel.habitos.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Nenhum treino cadastrado ainda.")
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(viewModel.habitos, key = { it.id }) { habito ->
                    CardHabito(habito, { aoAbrirDetalhe(habito.id) }, { viewModel.alternarConclusao(habito.id) })
                }
            }
        }
    }
}

@Composable
private fun CardHabito(habito: Habito, aoClicar: () -> Unit, aoAlternar: () -> Unit) {
    Card(onClick = aoClicar, shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)) {
        Row(Modifier.fillMaxWidth().padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(46.dp).clip(CircleShape).background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center) { Text(habito.emoji, fontSize = 21.sp) }
            Spacer(Modifier.width(14.dp))
            Column(Modifier.weight(1f)) {
                Text(habito.nome, fontWeight = FontWeight.SemiBold)
                Text("Meta: ${habito.meta}", style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary)
            }
            IconButton(onClick = aoAlternar) {
                Icon(
                    imageVector = if (habito.concluidoHoje) Icons.Filled.CheckCircle else Icons.Filled.RadioButtonUnchecked,
                    contentDescription = if (habito.concluidoHoje) "Treino concluído, tocar para desmarcar" else "Marcar treino como concluído",
                    tint = if (habito.concluidoHoje) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}
