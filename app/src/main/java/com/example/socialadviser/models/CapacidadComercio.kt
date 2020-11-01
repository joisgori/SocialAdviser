package com.example.socialadviser.models

import com.squareup.moshi.Json

data class CapacidadComercio (
    @field:Json(name="id_capacidad_comercio") val id:Int?,
    @field:Json(name="cantidad_servidores") val cantServidores:Int?,
    @field:Json(name="cantidad_max_clientes_cola") val canMaxClienCola:Int?
)