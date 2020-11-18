package com.example.socialadviser.models.results

import com.example.socialadviser.models.CapacidadComercio
import com.example.socialadviser.models.Municipio
import com.example.socialadviser.models.TipoComercio
import com.squareup.moshi.Json

data class Comercios2 (
    @field:Json(name="id_comercio") val id:Int?,
    @field:Json(name="nombre_comercio") val nombre:String?,
    @field:Json(name="telefono_comercio") val telefono:String?,
    @field:Json(name="movil_comercio") val celular:String?,
    @field:Json(name="facebook_comercio") val facebook:String?,
    @field:Json(name="messenger_comercio") val messenger:String?,
    @field:Json(name="sitioweb_comercio") val website:String?,
    @field:Json(name="descripcion_comercio") val descripcion:String?,
    @field:Json(name="id_tipocomercio") val tipoComercio: Int?,
    @field:Json(name="id_municipio") val municipio: Int?,
    @field:Json(name="id_capacidad") val capacidadComercio: Int?
)