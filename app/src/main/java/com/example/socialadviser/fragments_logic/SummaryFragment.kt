package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.R
import kotlinx.android.synthetic.main.fragment_summary.view.*


class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_summary, container, false)

        view.cancelar.setOnClickListener {
            this.findNavController().navigate(
                SummaryFragmentDirections.actionToMeetings()
            )
        }

        view.aceptar.setOnClickListener {
            this.findNavController().navigate(
                SummaryFragmentDirections.actionToMeetings()
            )
        }

        return view
    }

}