package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.R
import com.example.socialadviser.adapters.RecyclerBusinessAdapter
import kotlinx.android.synthetic.main.fragment_bussines.*


class bussinesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_bussines, container, false)

        return view
    }

    //Para el recyler
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_bussiness.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerBusinessAdapter()
        }

    }

}