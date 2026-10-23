package com.example.appvuelos_capebe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header
import com.example.appvuelos_capebe.ui.viewModel.CalendarioViewModel

// mis vuelos guardados
@Composable
fun MisVuelosScreen(
    viewModel: CalendarioViewModel,
    onNavigateBack: () -> Unit
) {
    val vuelosGuardados = viewModel.uiState.vuelosGuardados

    Scaffold(
        topBar = { Header("MIS VUELOS GUARDADOS") },
        bottomBar = { Footer() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (vuelosGuardados.isEmpty()) {
                Text(
                    text = "No tienes vuelos guardados aún.",
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                // lista de vuelos guardados
                vuelosGuardados.forEach { vuelo ->
                    Card(modifier = Modifier.fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(vuelo.fecha, fontWeight = FontWeight.Bold)
                            Text("Horario: ${vuelo.horario}")
                            Text("Base: ${vuelo.base}")
                            Text("Aeronave: ${vuelo.aeronave}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // boton volver
            OutlinedButton(
                onClick = { onNavigateBack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
        }
    }
}
