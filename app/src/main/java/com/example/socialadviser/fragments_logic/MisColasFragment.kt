package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.ColaXClienteAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.ClienteColaGet
import com.example.socialadviser.models.results.ColaClienteResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_mis_colas.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.ArrayList
import java.util.concurrent.TimeUnit


class MisColasFragment : Fragment() {

    lateinit var email:String
    lateinit var pass:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view =  inflater.inflate(R.layout.fragment_mis_colas, container, false)


        email = activity?.intent?.extras?.getString("mail")!!
        pass = activity?.intent?.extras?.getString("contra")!!

        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}

        val okhttp = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS).apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
                }
            }

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialadvisor.herokuapp.com/")
            .client(okhttp.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val service = retrofit.create(SocialAdviserApi::class.java)

        val call = service.getMisColas()

        call.enqueue(object: Callback<ColaClienteResponse>{
            override fun onResponse(
                call: Call<ColaClienteResponse>,
                response: Response<ColaClienteResponse>
            ) {

                val colaCliente:ColaClienteResponse? = response.body()

                val colCli = colaCliente?.results

                val listaF = ArrayList<ClienteColaGet>()

                if(colCli != null){
                    for(col in colCli){
                        if(col.cliente2?.correoelectronicoCliente == email){
                            listaF.add(col)
                        }
                    }
                }

                recycler_mis_colas.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = ColaXClienteAdapter(listaF)
                }

            }

            override fun onFailure(call: Call<ColaClienteResponse>, t: Throwable) {

            }

        })

        return view
    }


}