package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdTipocomercio(
    @Json(name = "id_tipo_comercio")
    val idTipoComercio: Int?,
    @Json(name = "nombre_tipo_comercio")
    val nombreTipoComercio: String?
)