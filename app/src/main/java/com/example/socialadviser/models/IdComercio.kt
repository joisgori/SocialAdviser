package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdComercio(
    @Json(name = "id_comercio")
    val idComercio: Int?,
    @Json(name = "nombre_comercio")
    val nombreComercio: String?,
    @Json(name = "telefono_comercio")
    val telefonoComercio: String?,
    @Json(name = "movil_comercio")
    val movilComercio: String?,
    @Json(name = "facebook_comercio")
    val facebookComercio: Any?,
    @Json(name = "messenger_comercio")
    val messengerComercio: Any?,
    @Json(name = "sitioweb_comercio")
    val sitiowebComercio: Any?,
    @Json(name = "descripcion_comercio")
    val descripcionComercio: Any?,
    @Json(name = "imagen_comercio")
    val imagenComercio: String?,
    @Json(name = "id_tipocomercio")
    val idTipocomercio: IdTipocomercio?,
    @Json(name = "id_municipio")
    val idMunicipio: IdMunicipio?,
    @Json(name = "id_capacidad")
    val idCapacidad: IdCapacidad?
)