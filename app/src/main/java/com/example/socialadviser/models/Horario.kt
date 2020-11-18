package com.example.socialadviser.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.text.SimpleDateFormat
import java.util.*


@JsonClass(generateAdapter = true)
data class Horario (
    @Json(name = "id_horario") var idHorario: Int?,
    @Json(name="hora_inicio") var hora_inicio:Any?,
    @Json(name="hora_final") var hora_final:Any?,
    @Json(name="fecha_inicio") var fecha_inicio:Any?,
    @Json(name="fecha_final") var fecha_final:Any?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("hora_inicio"),
        TODO("hora_final"),
        TODO("fecha_inicio"),
        TODO("fecha_final")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idHorario)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Horario> {
        override fun createFromParcel(parcel: Parcel): Horario {
            return Horario(parcel)
        }

        override fun newArray(size: Int): Array<Horario?> {
            return arrayOfNulls(size)
        }
    }

}

