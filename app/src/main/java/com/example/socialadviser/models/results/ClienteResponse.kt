package com.example.socialadviser.models.results

import com.example.socialadviser.models.Cliente
import com.example.socialadviser.models.Municipio
import com.squareup.moshi.Json

class ClienteResponse(
    @field:Json(name = "id_cliente") var id:Int?,
    @field:Json(name = "contrasenia_cliente") var contrasenia:String?,
    @field:Json(name = "telefono_cliente") var telefono:String?,
    @field:Json(name = "correoelectronico_cliente") var email:String?,
    @field:Json(name = "nombre_cliente") var nombre:String?,
    @field:Json(name = "apellido_cliente") var apellido:String?,
    @field:Json(name = "id_municipio") var municipio:Municipio?
)