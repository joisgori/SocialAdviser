package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TipoServicio(
    @Json(name = "id_tipo_servicio")
    val idTipoServicio: Int?,
    @Json(name = "nombre_tipo_servicio")
    val nombreTipoServicio: String?,
    @Json(name = "duracion_servicio")
    val duracionServicio: Double?
)