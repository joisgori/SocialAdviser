package com.example.socialadviser.models.results

import com.example.socialadviser.models.Municipio
import com.squareup.moshi.Json

data class MunicipioResponse (
    @field:Json(name = "count") val count:Int?,
    @field:Json(name = "next") val next:String?,
    @field:Json(name = "previous") val previous:String?,
    @field:Json(name = "results") val results:List<Municipio>)
