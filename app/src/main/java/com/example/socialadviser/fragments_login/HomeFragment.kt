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
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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
            val retrofit = Retrofit.Builder()
                .baseUrl("https://socialadvisor.herokuapp.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

            val service = retrofit.create(SocialAdviserApi::class.java)

            val call = service.login(editTextTextEmailAddress.text.toString(), editTextTextPassword.text.toString())



            call.enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.code() == 200){
                        startActivity(intent)
                    } else{
                        Toast.makeText(requireContext(), "Credenciales Invalidas", Toast.LENGTH_SHORT).show()
                    }
                }

            })

            /*var usuario = editTextTextEmailAddress.text.toString()
            var contra = editTextTextPassword.text.toString()
            if(usuario == "prueba@algo.com" && contra == "123"){
                //Toast.makeText(requireContext(), editTextTextEmailAddress.text, Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }else{
                Toast.makeText(requireContext(), "El usuario o la contraseña es incorrecta", Toast.LENGTH_SHORT).show()
            }*/


        }

        return view
    }
}