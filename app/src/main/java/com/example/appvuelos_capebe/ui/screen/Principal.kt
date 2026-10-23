package com.example.appvuelos_capebe.ui.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appvuelos_capebe.R
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header

// menu principal
@Composable
fun Principal(
    nombreSocio: String = "Socio CAPEBE",
    onNavigateToMisVuelos: () -> Unit = {},
    onNavigateToPlanesVuelo: () -> Unit = {},
    onNavigateToRecursos: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val context = LocalContext.current

    Scaffold(
        topBar = { Header("MENU PRINCIPAL CAPEBE") },
        bottomBar = { Footer() }
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            // imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.imagen_portada_capebe),
                contentDescription = "Fondo CAPEBE",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                alpha = 0.25f
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "CAPEBE",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Bienvenido, $nombreSocio",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Gracias por ser parte de CAPEBE",
                    fontSize = 14.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(32.dp))

                // botones menu
                Button(
                    onClick = { onNavigateToPlanesVuelo() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Vuelos")
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { onNavigateToMisVuelos() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Mis Vuelos Guardados")
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = { onNavigateToRecursos() },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Recursos Nativos")
                }

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedButton(
                    onClick = {
                        Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show()
                        onLogout()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Cerrar Sesion")
                }
            }
        }
    }
}
