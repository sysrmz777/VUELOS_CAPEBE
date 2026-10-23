package com.example.appvuelos_capebe.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header


@Composable
fun TerminosCondiciones(
    onAccept: () -> Unit,
    onDecline: () -> Unit
) {
    Scaffold(
        topBar = { Header("TÉRMINOS Y CONDICIONES") },
        bottomBar = { Footer() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Términos del servicio de vuelo CAPEBE",
                style = MaterialTheme.typography.titleLarge
            )


            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "1. El pasajero debe presentarse 2 horas antes en la losa.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "2. No se permiten reembolsos con menos de 24 horas de anticipación.")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "3. El uso de recursos nativos (brújula) es responsabilidad del piloto.")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedButton(onClick = onDecline) {
                    Text("Rechazo")
                }
                Button(onClick = onAccept) {
                    Text("Acepto")
                }
            }
        }
    }
}
