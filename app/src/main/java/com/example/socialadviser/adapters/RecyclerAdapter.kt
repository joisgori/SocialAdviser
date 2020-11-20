package com.example.socialadviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialadviser.R
import com.example.socialadviser.models.Cita2
import kotlinx.android.synthetic.main.card_bussiness.view.*
import kotlinx.android.synthetic.main.card_meetings.view.*
import kotlinx.android.synthetic.main.card_meetings.view.business_image

class RecyclerAdapter(private var citas:List<Cita2>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    init {
        changeDataSet(citas)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Cita2) = with(itemView){
            Glide.with(itemView).load(item.idComercio?.imagenComercio).into(business_image)
            comercio.text = item.idComercio?.nombreComercio
            hora.text = item.idHorario?.fechaInicio.toString()
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

    internal fun changeDataSet(newDataSet : List<Cita2>){
        this.citas = newDataSet
        notifyDataSetChanged()
    }


}