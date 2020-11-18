package com.example.socialadviser.fragments_logic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.HorarioAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.Horario
import com.example.socialadviser.models.results.HorarioResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_catalog.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class CatalogFragment : Fragment(){

    lateinit var adapter: HorarioAdapter
    lateinit var cliente2: Cliente2

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}

        arguments?.let {
            val safeArgs =CatalogFragmentArgs.fromBundle(it)

            Log.d("Cliente Si hay: ", safeArgs.cliente.toString())

            cliente2 = safeArgs.cliente
        }

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

        val call = service.getAllHorarios()

        call.enqueue(object: Callback<HorarioResponse> {
            override fun onResponse(
                call: Call<HorarioResponse>,
                response: Response<HorarioResponse>
            ) {
                val horarios:HorarioResponse? = response.body()

                val hor = horarios?.results

                val recyclerView = view.recycler_catalog


                adapter = object : HorarioAdapter(view.context){
                    override fun setClickListenerToBusiness(holder: ViewHolder, item: Horario) {
                        holder.itemView.setOnClickListener {
                            val nextAction = CatalogFragmentDirections.actionToNewBusiness(item, cliente2)
                            Navigation.findNavController(it).navigate(nextAction)
                        }
                    }

                }

                adapter.changeDataSet(hor!!)

                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(view.context)
            }

            override fun onFailure(call: Call<HorarioResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return view
    }
}