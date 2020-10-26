package com.example.socialadviser.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.R

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private val kode = arrayOf("d116df5",
        "36ffc75", "f5cfe78", "5b87628",
        "db8d14e", "9913dc4", "e120f96",
        "466251b")

    private val kategori = arrayOf("Kekayaan", "Teknologi",
        "Keluarga", "Bisnis",
        "Keluarga", "Hutang",
        "Teknologi", "Pidana")

    private val isi = arrayOf("pertanyaan 9",
        "pertanyaan 11", "pertanyaan 17", "test forum",
        "pertanyaan 12", "pertanyaan 18", "pertanyaan 20",
        "pertanyaan 21")

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemKode: TextView
        var itemKategori: TextView
        var itemIsi: TextView

        init {
            itemKode = itemView.findViewById(R.id.textview_card_title)
            itemKategori = itemView.findViewById(R.id.textview_card_subtitle)
            itemIsi = itemView.findViewById(R.id.textview_card_description)

            itemView.setOnClickListener {
                var position: Int = getAdapterPosition()
                val context = itemView.context

                //Toast.makeText(requireContext(), "El usuario o la contraseña es incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_meetings, viewGroup, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemKode.text = kode[i]
        viewHolder.itemKategori.text = kategori[i]
        viewHolder.itemIsi.text = isi[i]

    }

    override fun getItemCount(): Int {
        return kode.size
    }


}