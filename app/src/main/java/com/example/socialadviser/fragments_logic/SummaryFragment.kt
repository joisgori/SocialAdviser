package com.example.socialadviser.fragments_logic

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.*
import com.example.socialadviser.models.results.EstadoCitaResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.android.synthetic.main.fragment_summary.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.TimeUnit


class SummaryFragment : Fragment() {

    lateinit var horario: Horario
    lateinit var cliente2: Cliente2
    lateinit var comercios: Comercios
    lateinit var cita: Cita
    lateinit var estadoCita: IdEstadoCita
    //lateinit var format : SimpleDateFormat

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

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val safeArgs = SummaryFragmentArgs.fromBundle(it)

            Log.d("Si paso la info", safeArgs.comercio.toString())
            Log.d("Si paso la info", safeArgs.horario.toString())

            summary_negocio.text = safeArgs.comercio.nombreComercio
            summary_hora.text = safeArgs.horario.hora_inicio.toString()
            summary_fecha.text = safeArgs.horario.fecha_inicio.toString()

            horario = safeArgs.horario
            cliente2 = safeArgs.cliente
            comercios = safeArgs.comercio
            estadoCita = safeArgs.estado


            //horario = HorarioPost(safeArgs.horario.idHorario, safeArgs.horario.hora_inicio, safeArgs.horario.fecha_final, safeArgs.horario.hora_inicio, safeArgs.horario.hora_final)

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

        cita = Cita(comercios, horario, cliente2, estadoCita)


        val call = service.addCita(cita)

        view.aceptar.setOnClickListener {

            call.enqueue(object : Callback<Any>{
                override fun onResponse(call: Call<Any>, response: Response<Any>) {
                    if(response.code() == 201){
                        val nextActions = SummaryFragmentDirections.actionToMeetings()
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