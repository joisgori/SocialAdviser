package com.example.socialadviser.models

import com.squareup.moshi.Json

data class HorarioPost (
    @Json(name = "id_horario") var idHorario: Int?,
    @Json(name="hora_inicio") var hora_inicio:Any?,
    @Json(name="hora_final") var hora_final:Any?,
    @Json(name="fecha_inicio") var fecha_inicio:Any?,
    @Json(name="fecha_final") var fecha_final:Any?
)