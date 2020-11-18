package com.example.socialadviser.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.R
import com.example.socialadviser.models.Horario
import kotlinx.android.synthetic.main.card_catalog.view.*

abstract class HorarioAdapter internal constructor(context: Context): RecyclerView.Adapter<HorarioAdapter.ViewHolder>(){

    private var horario = emptyList<Horario>()
    private val inflater = LayoutInflater.from(context)

    init {
        changeDataSet(horario)
    }

    abstract fun setClickListenerToBusiness(holder: ViewHolder, item: Horario)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.card_catalog, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return horario.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(horario[position])
        setClickListenerToBusiness(holder, horario[position])
    }

    internal fun changeDataSet(newDataSet: List<Horario>){
        this.horario = newDataSet
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        fun bind(item:Horario) = with(itemView){
            horario_inicial.text = item.hora_inicio.toString()
            fecha_inicial.text = item.fecha_inicio.toString()
        }
    }
}