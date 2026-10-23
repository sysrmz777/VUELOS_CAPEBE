package com.example.appvuelos_capebe.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header
import com.example.appvuelos_capebe.ui.viewModel.CalendarioViewModel

// calendario de vuelos
@Composable
fun CalendarioVuelos(
    onNavigateBack: () -> Unit,
    onNavigateToConfirmacion: () -> Unit,
    viewModel: CalendarioViewModel = viewModel()
) {
    val state = viewModel.uiState

    Scaffold(
        topBar = { Header("CALENDARIO DE VUELOS") },
        bottomBar = { Footer() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Próximos vuelos recreativos",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // lista de vuelos
            state.vuelos.forEach { vuelo ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { viewModel.onVueloElegido(vuelo) },
                    colors = CardDefaults.cardColors(
                        containerColor = if (state.vueloElegido == vuelo)
                            MaterialTheme.colorScheme.primaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(vuelo.fecha, fontWeight = FontWeight.Bold)
                        Text("Horario: ${vuelo.horario}")
                        Text("Base: ${vuelo.base}")
                        Text("Aeronave: ${vuelo.aeronave}")
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            val seleccion = state.vueloElegido

            // boton elegir vuelo
            Button(
                onClick = {
                    if (seleccion != null) {
                        onNavigateToConfirmacion()
                    }
                },
                enabled = seleccion != null,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = if (seleccion == null) "Elige un vuelo" else "Elegir este vuelo")
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(
                onClick = { onNavigateBack() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Volver al Menú")
            }
        }
    }
}
