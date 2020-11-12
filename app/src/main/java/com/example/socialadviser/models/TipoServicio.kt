package com.example.socialadviser.models

import com.squareup.moshi.Json

data class TipoServicio(
    //@field:Json(name="id_tipo_servicio") val id:Int?,
    @field:Json(name="nombre_tipo_servicio") val nombre:String?,
    @field:Json(name="duracion_servicio") val duracion:Float?
)