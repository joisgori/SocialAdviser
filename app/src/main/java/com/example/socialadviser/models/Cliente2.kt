package com.example.socialadviser.models


import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cliente2(
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
    val idMunicipio: IdMunicipioXX?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("idMunicipio")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idCliente)
        parcel.writeString(contraseniaCliente)
        parcel.writeString(telefonoCliente)
        parcel.writeString(correoelectronicoCliente)
        parcel.writeString(nombreCliente)
        parcel.writeString(apellidoCliente)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cliente2> {
        override fun createFromParcel(parcel: Parcel): Cliente2 {
            return Cliente2(parcel)
        }

        override fun newArray(size: Int): Array<Cliente2?> {
            return arrayOfNulls(size)
        }
    }

}