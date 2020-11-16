package com.example.socialadviser.interfaces

import com.example.socialadviser.models.Cliente
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.results.CitasResponse
import com.example.socialadviser.models.results.ClienteResponse
import com.example.socialadviser.models.results.ComercioResponse
import com.example.socialadviser.models.results.MunicipioResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface SocialAdviserApi {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("comercios")
    fun getAllComercios() : Call<ComercioResponse>

    @GET("onecliente/correo={mail}&contra={pass}")
    fun login(@Path("mail") mail:String, @Path("pass") pass:String) :  Call<Cliente2>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("clientes/")
    fun addUser(@Body cliente:Cliente) : Call<ClienteResponse>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("municipios")
    fun getAllMunicipios() : Call<MunicipioResponse>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("citas")
    fun getAllCitas() : Call<CitasResponse>
}