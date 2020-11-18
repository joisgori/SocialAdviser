package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdHorario(
    @Json(name = "id_horario")
    val idHorario: Int?,
    @Json(name = "hora_inicio")
    val horaInicio: Any?,
    @Json(name = "hora_final")
    val horaFinal: Any?,
    @Json(name = "fecha_inicio")
    val fechaInicio: Any?,
    @Json(name = "fecha_final")
    val fechaFinal: Any?
)