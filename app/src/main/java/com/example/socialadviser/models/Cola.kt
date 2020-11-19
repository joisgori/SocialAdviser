package com.example.socialadviser.models

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cola (
    @Json(name = "id_cola")
    val idCola: Int?,
    @Json(name = "tiempo_esperado_medio")
    val tiempoEsperado:Any?,
    @Json(name = "cola_comercio")
    val colaComercios: Comercios?,
    @Json(name= "id_tipo_cola")
    val tipoCola: TipoCola?,
    @Json(name = "id_tipo_servicio")
    val tipoServicio: TipoServicio?
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        TODO("tiempoEsperado"),
        parcel.readParcelable(Comercios::class.java.classLoader),
        TODO("tipoCola"),
        TODO("tipoServicio")
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idCola)
        parcel.writeParcelable(colaComercios, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cola> {
        override fun createFromParcel(parcel: Parcel): Cola {
            return Cola(parcel)
        }

        override fun newArray(size: Int): Array<Cola?> {
            return arrayOfNulls(size)
        }
    }

}