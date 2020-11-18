package com.example.socialadviser.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.socialadviser.R
import com.example.socialadviser.models.Comercios
import kotlinx.android.synthetic.main.card_bussiness.view.*

abstract class RecyclerBusinessAdapter internal constructor(context: Context) : RecyclerView.Adapter<RecyclerBusinessAdapter.ViewBHolder>() {

    private var comercios = emptyList<Comercios>()
    private val inflater = LayoutInflater.from(context)

    init{
        changeDataSet(comercios)
    }

    abstract fun setClickListenerToSummary(holder: ViewBHolder, item: Comercios)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewBHolder {
        val v = inflater.inflate(R.layout.card_bussiness, viewGroup, false)
        return ViewBHolder(v)

    }

    override fun getItemCount(): Int {
        return comercios.size
    }

    override fun onBindViewHolder(viewHolder: ViewBHolder, i: Int) {
        viewHolder.bind(comercios[i])
        setClickListenerToSummary(viewHolder, comercios[i])
    }


    internal fun changeDataSet(newDataSet : List<Comercios>){
        this.comercios = newDataSet
        notifyDataSetChanged()
    }


    inner class ViewBHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (item: Comercios) = with(itemView){
            Glide.with(itemView).load(item.imagenComercio).into(business_image)
            textview_card_business_title.text = item.nombreComercio
            textview_card_business_description.text = item.descripcionComercio.toString()
        }
    }

}