package com.example.socialadviser.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cola (
    @Json(name = "id_cola")
    val idCola: Int?,
    @Json(name = "tiempo_esperado_medio")
    val tiempoEsperado:Any?,
    @Json(name = "cola_comercio")
    val colaComercios: Comercios?,
    @Json(name= "id_tipo_cola")
    val tipoCola: TipoCola?,
    @Json(name = "id_tipo_servicio")
    val tipoServicio: TipoServicio?
)