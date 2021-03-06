package com.example.socialadviser.models

import com.example.socialadviser.models.results.Comercios2
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cita(
    @Json(name = "id_comercio")
    val idComercio: Comercios?,
    @Json(name = "id_horario")
    val idHorario: Horario?,
    @Json(name = "id_cliente")
    val idCliente: Cliente2?,
    @Json(name = "id_estado_cita")
    val idEstadoCita: IdEstadoCita?
)