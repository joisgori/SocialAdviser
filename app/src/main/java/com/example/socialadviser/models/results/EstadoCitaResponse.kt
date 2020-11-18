package com.example.socialadviser.models.results

import com.example.socialadviser.models.IdEstadoCita
import com.squareup.moshi.Json

data class EstadoCitaResponse (
    @field:Json(name = "count") val count:Int?,
    @field:Json(name = "next") val next:String?,
    @field:Json(name = "previous") val previous:String?,
    @field:Json(name = "results") val results:List<IdEstadoCita>?
)