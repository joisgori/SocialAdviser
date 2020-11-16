package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HorarioAdvanced(
    @Json(name = "id_horario")
    val idHorario: Int,
    @Json(name = "hora_inicio")
    val horaInicio: String,
    @Json(name = "hora_final")
    val horaFinal: String,
    @Json(name = "fecha_inicio")
    val fechaInicio: String,
    @Json(name = "fecha_final")
    val fechaFinal: String
)