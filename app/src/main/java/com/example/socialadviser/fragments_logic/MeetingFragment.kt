package com.example.socialadviser.fragments_logic

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.R
import com.example.socialadviser.adapters.RecyclerAdapter
import kotlinx.android.synthetic.main.fragment_catalog.*
import kotlinx.android.synthetic.main.fragment_catalog.view.*
import kotlinx.android.synthetic.main.fragment_meeting.*
import kotlinx.android.synthetic.main.fragment_meeting.view.*
import java.time.Month
import java.time.Year
import java.util.*


class MeetingFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meeting, container, false)

        view.floatingActionButtonNewMeet.setOnClickListener{
            this.findNavController().navigate(
                MeetingFragmentDirections.actionToNewMeet()

            )

        }


        return view
    }


    //Para el recyler
    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        recycler_meetings.apply {

            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerAdapter()
        }

    }

}