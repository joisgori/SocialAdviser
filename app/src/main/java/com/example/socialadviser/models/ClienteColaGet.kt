package com.example.socialadviser.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ClienteColaGet (
    @Json(name = "id_cola_cliente")
    val idCola: Int?,
    @Json(name = "cola")
    val cola:Cola?,
    @Json(name = "cliente")
    val cliente2: Cliente2?,
    @Json(name = "turno")
    val turno: Int?,
    @Json(name= "tiempo_estimado")
    val tiempoEstimado: Any?,
    @Json(name = "atentido")
    val atendido: Boolean?,
    @Json(name = "tiempo_inicial")
    val tiempoInicial: Any?
)