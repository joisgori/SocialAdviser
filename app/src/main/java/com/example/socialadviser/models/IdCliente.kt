package com.example.socialadviser.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdCliente(
    @Json(name = "id_cliente")
    val idCliente: Int?,
    @Json(name = "contrasenia_cliente")
    val contraseniaCliente: String?,
    @Json(name = "telefono_cliente")
    val telefonoCliente: String?,
    @Json(name = "correoelectronico_cliente")
    val correoelectronicoCliente: String?,
    @Json(name = "nombre_cliente")
    val nombreCliente: String?,
    @Json(name = "apellido_cliente")
    val apellidoCliente: String?,
    @Json(name = "id_municipio")
    val idMunicipio: IdMunicipioX?
)