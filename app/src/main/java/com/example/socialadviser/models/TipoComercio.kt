package com.example.socialadviser.models

import com.squareup.moshi.Json

data class TipoComercio (
    @field:Json(name = "id_tipo_comercio") val id:Int?,
    @field:Json(name = "nombre_tipo_comercio") val nombre:String?
)