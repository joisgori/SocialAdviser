package com.example.socialadviser.fragments_login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        view.Button_Home_Login.setOnClickListener {
            this.findNavController().navigate(
                homeDirections.openRegisterAction()
            )
        }

        return view
    }

}