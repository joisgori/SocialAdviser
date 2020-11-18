package com.example.socialadviser.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Comercios (
    @Json(name = "id_comercio")
    val idComercio: Int?,
    @Json(name = "nombre_comercio")
    val nombreComercio: String?,
    @Json(name = "telefono_comercio")
    val telefonoComercio: String?,
    @Json(name = "movil_comercio")
    val movilComercio: String?,
    @Json(name = "facebook_comercio")
    val facebookComercio: Any?,
    @Json(name = "messenger_comercio")
    val messengerComercio: Any?,
    @Json(name = "sitioweb_comercio")
    val sitiowebComercio: Any?,
    @Json(name = "descripcion_comercio")
    val descripcionComercio: Any?,
    @Json(name = "imagen_comercio")
    val imagenComercio: String?,
    @Json(name = "id_tipocomercio")
    val idTipocomercio: IdTipocomercio?,
    @Json(name = "id_municipio")
    val idMunicipio: IdMunicipio?,
    @Json(name = "id_capacidad")
    val idCapacidad: IdCapacidad?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        TODO("facebookComercio"),
        TODO("messengerComercio"),
        TODO("sitiowebComercio"),
        TODO("descripcionComercio"),
        parcel.readString(),
        TODO("idTipocomercio"),
        TODO("idMunicipio"),
        TODO("idCapacidad")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idComercio)
        parcel.writeString(nombreComercio)
        parcel.writeString(telefonoComercio)
        parcel.writeString(movilComercio)
        parcel.writeString(imagenComercio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comercios> {
        override fun createFromParcel(parcel: Parcel): Comercios {
            return Comercios(parcel)
        }

        override fun newArray(size: Int): Array<Comercios?> {
            return arrayOfNulls(size)
        }
    }


}