package com.example.socialadviser

import com.example.socialadviser.models.Departamento
import com.example.socialadviser.models.Post
import com.example.socialadviser.models.Respuesta
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface JsonPlaceHolderApi {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("departamentos")
    fun getAllDepartments(): Call<Respuesta>


}