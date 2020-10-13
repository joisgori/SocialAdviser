package com.example.socialadviser.models

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

//Agregar extensiones para base de datos postgresql
@Entity(tableName = "cita")
class meet() : Parcelable {

    @PrimaryKey
    @field:Json(name="id_cita")
    val ID_Cita:integer,

    //@field:Json(name="id_comercio")
    val ID_Comercio:integer,

    //@field:Json(name="id_horario")
    val ID_Horario:int,

    //@field:Json(name="id_cliente")
    val ID_Cliente:int,

    //@field:Json(name="id_estado_cita")
    val ID_Estado_Cita:int,

    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<meet> {
        override fun createFromParcel(parcel: Parcel): meet {
            return meet(parcel)
        }

        override fun newArray(size: Int): Array<meet?> {
            return arrayOfNulls(size)
        }
    }

}