package com.example.socialadviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialadviser.R
import com.example.socialadviser.models.ClienteColaGet
import kotlinx.android.synthetic.main.card_mis_colas.view.*

class ColaXClienteAdapter (private var colaxCliente:List<ClienteColaGet>) : RecyclerView.Adapter<ColaXClienteAdapter.ViewHolder>(){

    init {
        changeDataSet(colaxCliente)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ClienteColaGet) = with(itemView){
            Glide.with(itemView).load(item.cola?.colaComercios?.imagenComercio).into(business_image)
            nombreCola.text = item.cola?.tipoCola?.nombreTipoCola
            servicio.text = item.cola?.tipoServicio?.nombreTipoServicio
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_mis_colas, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.bind(colaxCliente[i])

    }

    override fun getItemCount(): Int {
        return colaxCliente.size
    }

    internal fun changeDataSet(newDataSet : List<ClienteColaGet>){
        this.colaxCliente = newDataSet
        notifyDataSetChanged()
    }


}