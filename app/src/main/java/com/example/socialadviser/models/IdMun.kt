package com.example.socialadviser.models

import com.squareup.moshi.Json

data class IdMun (
    @field:Json(name="id_municipio") val id:Int?,
    @field:Json(name="nombre_municipio") val nombre:String?,
    @field:Json(name="id_departamento") val departamento:Int?
)