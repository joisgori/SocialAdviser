package com.example.socialadviser.models

import com.squareup.moshi.Json

data class EstadoCita (
    @Json(name="id_estado_cita") val id:Int?,
    @Json(name="nombre_estado") val nombre:String?,
    @Json(name="valor_estado") val estado:Boolean?
)