package com.example.socialadviser.models


import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdEstadoCita(
    @Json(name = "id_estado_cita")
    val idEstadoCita: Int?,
    @Json(name = "nombre_estado")
    val nombreEstado: String?,
    @Json(name = "valor_estado")
    val valorEstado: Boolean?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idEstadoCita)
        parcel.writeString(nombreEstado)
        parcel.writeValue(valorEstado)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<IdEstadoCita> {
        override fun createFromParcel(parcel: Parcel): IdEstadoCita {
            return IdEstadoCita(parcel)
        }

        override fun newArray(size: Int): Array<IdEstadoCita?> {
            return arrayOfNulls(size)
        }
    }

}