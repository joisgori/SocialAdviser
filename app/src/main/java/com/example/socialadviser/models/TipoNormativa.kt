package com.example.socialadviser.models

import com.squareup.moshi.Json

data class TipoNormativa (
    //@field:Json(name="id_normativa") val id:Int?,
    @field:Json(name="nombre_tipo_normativa") val nombre:String?
)