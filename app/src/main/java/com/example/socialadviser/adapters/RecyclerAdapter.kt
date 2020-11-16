package com.example.socialadviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.R
import com.example.socialadviser.models.Cita
import kotlinx.android.synthetic.main.card_meetings.view.*

class RecyclerAdapter(private var citas:List<Cita>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Cita) = with(itemView){
            comercio.text = item.comercio?.nombre
            hora.text = item.horario?.fecha_inicio
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_meetings, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(citas[i])

    }

    override fun getItemCount(): Int {
        return citas.size
    }

    internal fun changeDataSet(newDataSet : List<Cita>){
        this.citas = newDataSet
        notifyDataSetChanged()
    }


}