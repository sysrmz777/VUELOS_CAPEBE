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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appvuelos_capebe.ui.components.Footer
import com.example.appvuelos_capebe.ui.components.Header
import com.example.appvuelos_capebe.ui.viewModel.LoginViewModel

// login
@Composable
fun Login(
    onNavigateToRegister: () -> Unit = {},
    onNavigateBackToHome: () -> Unit = {},
    onLoginSuccess: (String) -> Unit = {},
    viewModel: LoginViewModel = viewModel()
) {
    val state = viewModel.uiState
    val context = LocalContext.current

    Scaffold(
        topBar = { Header("INICIO DE SESIÓN CAPEBE") },
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
                text = "Acceso para Socios",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // correo
            OutlinedTextField(
                value = state.email,
                onValueChange = { viewModel.onEmailChanged(it) },
                label = { Text("Correo Electrónico") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(12.dp))

            // contrasena
            OutlinedTextField(
                value = state.password,
                onValueChange = { viewModel.onPasswordChanged(it) },
                label = { Text("Contraseña") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // mensaje de error
            viewModel.errorMessage?.let { error ->
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // boton ingresar
            Button(
                onClick = {
                    viewModel.onLoginClick(context) { nombreSocio ->
                        Toast.makeText(context, "Bienvenido $nombreSocio", Toast.LENGTH_SHORT).show()
                        onLoginSuccess(nombreSocio)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = {
                    Toast.makeText(context, "Contacta a administración CAPEBE", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("¿Olvidaste tu contraseña?")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // boton ir a registro
            Button(
                onClick = { onNavigateToRegister() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Crear nueva cuenta de Socio")
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = { onNavigateBackToHome() }) {
                Text("Volver al Inicio")
            }
        }
    }
}
