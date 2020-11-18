package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdDepartamento(
    @Json(name = "id_departamento")
    val idDepartamento: Int?,
    @Json(name = "nombre_departamento")
    val nombreDepartamento: String?
)