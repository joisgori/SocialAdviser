package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cita2(
    @Json(name = "id_cita")
    val idCita: Int?,
    @Json(name = "id_comercio")
    val idComercio: IdComercio?,
    @Json(name = "id_horario")
    val idHorario: IdHorario?,
    @Json(name = "id_cliente")
    val idCliente: Cliente2?,
    @Json(name = "id_estado_cita")
    val idEstadoCita: IdEstadoCita?
)