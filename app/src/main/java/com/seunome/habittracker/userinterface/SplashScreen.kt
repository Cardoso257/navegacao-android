package com.seunome.habittracker.userinterface

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(estaLogado: Boolean, aoTerminarVerificacao: (Boolean) -> Unit) {
    LaunchedEffect(Unit) {
        delay(1200)
        aoTerminarVerificacao(estaLogado)
    }

    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("🏃", fontSize = 52.sp)
            Spacer(Modifier.height(16.dp))
            Text("HabitTracker", color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold, fontSize = 28.sp)
            Spacer(Modifier.height(8.dp))
            Text("Diário de Treinos", color = MaterialTheme.colorScheme.onPrimary)
            Spacer(Modifier.height(24.dp))
            CircularProgressIndicator(color = MaterialTheme.colorScheme.onPrimary)
        }
    }
}
