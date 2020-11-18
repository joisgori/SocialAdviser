package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdMunicipioX(
    @Json(name = "id_municipio")
    val idMunicipio: Int?,
    @Json(name = "nombre_municipio")
    val nombreMunicipio: String?,
    @Json(name = "id_departamento")
    val idDepartamento: IdDepartamentoX?
)