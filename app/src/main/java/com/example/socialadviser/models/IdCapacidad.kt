package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdCapacidad(
    @Json(name = "id_capacidad_comercio")
    val idCapacidadComercio: Int?,
    @Json(name = "cantidad_servidores")
    val cantidadServidores: Int?,
    @Json(name = "cantidad_max_clientes_cola")
    val cantidadMaxClientesCola: Int?,
    @Json(name = "promedio_de_atencion_minutos")
    val promedioDeAtencionMinutos: Double?
)