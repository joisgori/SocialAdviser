package com.example.socialadviser.interfaces

import com.example.socialadviser.models.*
import com.example.socialadviser.models.results.*
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

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("horarios")
    fun getAllHorarios() : Call <HorarioResponse>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @POST("citas/")
    fun addCita(@Body citaPost: Cita) : Call<Any>

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("estadocita")
    fun getEstadoCita() : Call <EstadoCitaResponse>


}