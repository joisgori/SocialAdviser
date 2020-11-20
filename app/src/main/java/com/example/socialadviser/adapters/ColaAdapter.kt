package com.example.socialadviser.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialadviser.R
import com.example.socialadviser.models.Cola
import kotlinx.android.synthetic.main.card_cola.view.*
import kotlinx.android.synthetic.main.card_meetings.view.*

abstract class ColaAdapter internal constructor(context: Context) : RecyclerView.Adapter<ColaAdapter.ViewHolder>()
{

    private var colas = emptyList<Cola>()
    private val inflater = LayoutInflater.from(context)

    init {
        changeDataSet(colas)
    }

    abstract fun setClickListenerToSummaryCola(holder:ViewHolder, item: Cola)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = inflater.inflate(R.layout.card_cola, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(colas[position])
        setClickListenerToSummaryCola(holder, colas[position])
    }

    override fun getItemCount(): Int {
        return colas.size
    }

    internal fun changeDataSet(newDataSet : List<Cola>){
        this.colas = newDataSet
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Cola) = with(itemView){
            Glide.with(itemView).load(item.colaComercios?.imagenComercio).into(business_imagee)
            nombreComercio.text = item.colaComercios?.nombreComercio
            tiempoEsperado.text = item.tiempoEsperado.toString()
        }
    }


}