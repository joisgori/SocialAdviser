package com.example.socialadviser.fragments_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.R
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        view.Button_Cancel_Register.setOnClickListener {

            //Lógica para regresar al login
            this.findNavController().navigateUp()
        }



        return view
    }

}