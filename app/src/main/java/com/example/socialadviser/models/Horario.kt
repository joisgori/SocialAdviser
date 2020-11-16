package com.example.socialadviser.models

import com.squareup.moshi.Json
import java.text.SimpleDateFormat
import java.util.*

data class Horario (
    @Json(name="hora_inicio") val hora_inicio:String?,
    @Json(name="hora_final") val hora_final:String?,
    @Json(name="fecha_inicio") val fecha_inicio:String?,
    @Json(name="fecha_final") val fecha_final:String?
)