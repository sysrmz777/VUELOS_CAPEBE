package com.example.appvuelos_capebe.ui.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header
import com.example.appvuelos_capebe.ui.viewModel.CalendarioViewModel

// confirmacion de vuelo
@Composable
fun ConfirmacionVuelo(
    nombreSocio: String,
    viewModel: CalendarioViewModel,
    onNavigateHome: () -> Unit
) {
    val context = LocalContext.current
    val vuelo = viewModel.uiState.vueloElegido

    Scaffold(
        topBar = { Header("CONFIRMACIÓN DE VUELO") },
        bottomBar = { Footer() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Socio: $nombreSocio",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            // datos del vuelo elegido
            if (vuelo != null) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(vuelo.fecha, fontWeight = FontWeight.Bold)
                        Text("Horario: ${vuelo.horario}")
                        Text("Base: ${vuelo.base}")
                        Text("Aeronave: ${vuelo.aeronave}")
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // boton confirmar
            Button(
                onClick = {
                    viewModel.guardarVueloConfirmado()
                    Toast.makeText(context, "Vuelo guardado en Mis Vuelos", Toast.LENGTH_SHORT).show()
                    onNavigateHome()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar y Guardar Vuelo")
            }
        }
    }
}
