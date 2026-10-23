package com.example.appvuelos_capebe.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class VueloModel(
    val fecha: String,
    val horario: String,
    val base: String,
    val aeronave: String
)

data class CalendarioModel(
    val vuelos: List<VueloModel> = emptyList(),
    val vuelosGuardados: List<VueloModel> = emptyList(),
    val vueloElegido: VueloModel? = null
)

class CalendarioViewModel : ViewModel() {

    // estado
    var uiState by mutableStateOf(CalendarioModel(vuelos = crearVuelosFicticios()))
        private set

    // seleccionar vuelo
    fun onVueloElegido(vuelo: VueloModel) {
        uiState = uiState.copy(vueloElegido = vuelo)
    }

    // guardar vuelo confirmado
    fun guardarVueloConfirmado() {
        val elegido = uiState.vueloElegido
        if (elegido != null) {
            uiState = uiState.copy(
                vuelosGuardados = uiState.vuelosGuardados + elegido
            )
        }
    }

    // vuelos ficticios
    private fun crearVuelosFicticios(): List<VueloModel> {
        return listOf(
            VueloModel("Sábado 24/10/2026", "10:00 - 11:00", "Tobalaba", "CC-AAA Cessna 172"),
            VueloModel("Sábado 24/10/2026", "11:30 - 12:30", "Tobalaba", "CC-BBB Piper PA-28"),
            VueloModel("Domingo 25/10/2026", "09:00 - 10:00", "Talcahuano", "CC-CCC Cessna 150"),
            VueloModel("Sábado 31/10/2026", "15:00 - 16:00", "Tobalaba", "CC-AAA Cessna 172"),
            VueloModel("Sábado 07/11/2026", "10:30 - 11:30", "Talcahuano", "CC-BBB Piper PA-28")
        )
    }
}