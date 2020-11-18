package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.RecyclerBusinessAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.Comercios
import com.example.socialadviser.models.Horario
import com.example.socialadviser.models.IdEstadoCita
import com.example.socialadviser.models.results.ComercioResponse
import com.example.socialadviser.models.results.EstadoCitaResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_bussines.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


class BussinesFragment : Fragment() {

    lateinit var adapter : RecyclerBusinessAdapter
    lateinit var horario : Horario
    lateinit var cliente2: Cliente2
    lateinit var estadoCita: IdEstadoCita

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bussines, container, false)

        arguments?.let {
            val safeArgs = BussinesFragmentArgs.fromBundle(it)

            horario = safeArgs.horario
            cliente2 = safeArgs.cliente
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

        val call = service.getAllComercios()

        val estado = service.getEstadoCita()

        estado.enqueue(object : Callback<EstadoCitaResponse> {
            override fun onResponse(
                call: Call<EstadoCitaResponse>,
                response: Response<EstadoCitaResponse>
            ) {
                val estados: EstadoCitaResponse? = response.body()

                val est = estados?.results

                estadoCita = est!![0]

            }

            override fun onFailure(call: Call<EstadoCitaResponse>, t: Throwable) {
            }

        })

        call.enqueue(object : Callback<ComercioResponse>{
            override fun onResponse(
                call: Call<ComercioResponse>,
                response: Response<ComercioResponse>
            ) {
                val comercios:ComercioResponse? = response.body()

                val com = comercios?.results

                val recyclerView = view.recycler_bussiness

                adapter = object: RecyclerBusinessAdapter(view.context){
                    override fun setClickListenerToSummary(holder: ViewBHolder, item: Comercios) {
                        holder.itemView.setOnClickListener {
                            val nextAction = BussinesFragmentDirections.actionToSummary(horario,item,cliente2, estadoCita)
                            Navigation.findNavController(it).navigate(nextAction)
                        }
                    }

                }

                adapter.changeDataSet(com!!)

                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(view.context)

            }

            override fun onFailure(call: Call<ComercioResponse>, t: Throwable) {
            }

        })

        return view
    }

}