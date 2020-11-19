package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.ClienteCola
import com.example.socialadviser.models.Cola
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_cola_summary.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit


class ColaSummary : Fragment() {

    lateinit var cliente: Cliente2
    lateinit var cola: Cola
    lateinit var clienteCola: ClienteCola


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_cola_summary, container, false)

        view.cancelar.setOnClickListener {
            this.findNavController().navigate(
                ColaSummaryDirections.actionColaSummaryToMeetingFragment2()
            )
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            val safeArgs = ColaSummaryArgs.fromBundle(it)

            cliente = safeArgs.cliente
            cola = safeArgs.cola
        }

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

        val min = 1
        val max = 10
        val random = Random().nextInt((max-min)+1) + min

        clienteCola = ClienteCola(cola, cliente, random, "00:10:00", false, "2020-11-10T06:00:00-06:00")

        val call = service.addColaCliente(clienteCola)

        view.aceptar.setOnClickListener {
            call.enqueue(object: Callback<Any>{
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if(response.code() == 201){
                        val nextActions = ColaSummaryDirections.actionColaSummaryToMeetingFragment2()
                        Navigation.findNavController(it).navigate(nextActions)
                    }
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }

}