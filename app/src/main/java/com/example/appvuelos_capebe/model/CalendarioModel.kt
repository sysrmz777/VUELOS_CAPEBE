package com.example.appvuelos_capebe.model 

data class CalendarioModel(
    val vuelos: List<VueloModel> = emptyList(),
    val vueloElegido: VueloModel? = null,
    val vuelosGuardados: List<VueloModel> = emptyList()
)