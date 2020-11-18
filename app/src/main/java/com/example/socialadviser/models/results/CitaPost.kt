package com.example.socialadviser.models.results

import com.example.socialadviser.models.*
import com.squareup.moshi.Json

data class CitaPost (
    @Json(name = "id_cita")
    val idCita: Int?,
    @Json(name = "id_comercio")
    val idComercio: Comercios?,
    @Json(name = "id_horario")
    val idHorario: HorarioPost?,
    @Json(name = "id_cliente")
    val idCliente: Cliente2?,
    @Json(name = "id_estado_cita")
    val idEstadoCita: IdEstadoCita?
)
