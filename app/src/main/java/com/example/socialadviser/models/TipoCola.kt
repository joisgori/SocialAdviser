package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TipoCola(
    @Json(name = "id_tipo_cola")
    val idTipoCola: Int?,
    @Json(name = "nombre_tipo_cola")
    val nombreTipoCola: String?,
    @Json(name = "valor_tipo_cola")
    val valorTipoCola: Boolean?
)