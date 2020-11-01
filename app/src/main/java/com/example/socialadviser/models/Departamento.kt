package com.example.socialadviser.models

import com.squareup.moshi.Json

data class Departamento (
    @field:Json(name="id_departamento") val id:Int?,
    @field:Json(name="nombre_departamento") val nombre:String?
)