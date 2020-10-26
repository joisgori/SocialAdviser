package com.example.socialadviser.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

data class Post (
    @field:Json(name="userId") val userId:Int?,
    @field:Json(name="id") val id:Int?,
    @field:Json(name="title") val title:String?,
    @field:Json(name="body") val text:String?
)





