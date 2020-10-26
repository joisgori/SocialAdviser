package com.example.socialadviser.fragments_login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.AppLogic
import com.example.socialadviser.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        view.Button_Home_Register.setOnClickListener {
            this.findNavController().navigate(
                HomeFragmentDirections.openRegisterAction()
            )
        }

        val intent = Intent(requireContext(), AppLogic::class.java)

        view.Button_Home_Login.setOnClickListener {
            var usuario = editTextTextEmailAddress.text.toString()
            var contra = editTextTextPassword.text.toString()
            if(usuario == "prueba@algo.com" && contra == "123"){
                //Toast.makeText(requireContext(), editTextTextEmailAddress.text, Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(), "El usuario o la contraseña es incorrecta", Toast.LENGTH_SHORT).show()
            }


        }

        return view
    }
}