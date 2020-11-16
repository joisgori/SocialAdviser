package com.example.socialadviser.models

import com.squareup.moshi.Json

data class Cita(
    @Json(name="id_cita") val id:Int?,
    @Json(name="id_comercio") val comercio:Comercios?,
    @Json(name="id_horario") val horario:Horario?,
    @Json(name="id_cliente") val cliente:Cliente2?,
    @Json(name="id_estado_cita") val estadoCita:EstadoCita?
)