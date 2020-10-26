package com.example.socialadviser.fragments_login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.JsonPlaceHolderApi
import com.example.socialadviser.R
import com.example.socialadviser.models.Respuesta
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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialadvisor.herokuapp.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(JsonPlaceHolderApi::class.java)

        val call = service.getAllDepartments()

        Log.d("Calls: ", call.toString())

        call.enqueue(object : Callback<Respuesta> {
            override fun onResponse(call: Call<Respuesta>, response: Response<Respuesta>) {
                if (!response.isSuccessful())
                {
                    test_view_result.setText("Code: " + response.code())
                    return
                }
                val departamentos:Respuesta? = response.body()
                val something = departamentos?.results

                if(something!= null) {
                    for (departamento in something)
                    {
                        var content = ""
                        content += "ID: " + departamento.id+ "\n"
                        content += "Nombre Departamento: " + departamento.nombre+ "\n"
                        test_view_result.append(content)
                    }
                }

            }
            override fun onFailure(call: Call<Respuesta>, t:Throwable) {
                test_view_result.setText(t.message)
            }
        })

        return view
    }

}
