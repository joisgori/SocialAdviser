package com.example.socialadviser.models

import com.squareup.moshi.Json

data class TipoCola(
    @field:Json(name="id_tipo_cola") val id:Int?,
    @field:Json(name="nombre_tipo_cola") val nombre:String?,
    @field:Json(name="valor_tipo_cola") val tipo:Boolean?
)