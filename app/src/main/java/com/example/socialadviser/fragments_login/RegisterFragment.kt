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
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente
import com.example.socialadviser.models.results.ClienteResponse
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

        val intent = Intent(requireContext(), AppLogic::class.java)

        view.Button_Accept_Register.setOnClickListener{
            val retrofit = Retrofit.Builder()
                .baseUrl("https://socialadvisor.herokuapp.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(SocialAdviserApi::class.java)

            val cliente = Cliente(contraseña.text.toString(),numero.text.toString(),correo.text.toString(), nombre.text.toString(), apellido.text.toString())

            val call = service.addUser(cliente)

            call.enqueue(object : Callback<ClienteResponse>{
                override fun onFailure(call: Call<ClienteResponse>, t: Throwable) {
                    Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ClienteResponse>, response: Response<ClienteResponse>) {
                    Toast.makeText(requireContext(), "codigo malo: " + response.code(), Toast.LENGTH_SHORT).show()
                    if(response.code() == 201){
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show()
                    }
                }

            })

        }
        return view
    }

}