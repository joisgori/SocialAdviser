package com.example.socialadviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.R
import com.example.socialadviser.models.Comercios
import kotlinx.android.synthetic.main.card_bussiness.view.*

class RecyclerBusinessAdapter : RecyclerView.Adapter<RecyclerBusinessAdapter.ViewBHolder>() {

    private var items = emptyList<Comercios>()


    inner class ViewBHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind (item: Comercios) = with(itemView){
            textview_card_business_title.text = item.nombre
            textview_card_business_description.text = item.descripcion
            textview_card_business_subtitle.text = item.facebook

        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewBHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_bussiness, viewGroup, false)
        return ViewBHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewBHolder, i: Int) {
        viewHolder.bind(items[i])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    internal fun changeDataSet(newDataSet : List<Comercios>){
        this.items = newDataSet
        notifyDataSetChanged()
    }

}