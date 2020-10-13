package com.example.socialadviser.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "horario")
public class horario {

    @PrimaryKey
    @field:Json(name="id_horario")
    val ID_Horario:int,

    @field:Json(name="hora_inicio")
    val Hora_Inicio:Date,

    @field:Json(name="hora_final")
    val Hora_Final:Date,

    @field:Json(name="fecha_inicio")
    val Fecha_Inicio: Date,

    @field:Json(name="fecha_final")
    val Fecha_Final:Date,
}