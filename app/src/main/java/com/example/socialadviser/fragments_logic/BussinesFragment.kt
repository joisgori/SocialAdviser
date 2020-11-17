package com.example.socialadviser.fragments_logic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.RecyclerBusinessAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Comercios
import com.example.socialadviser.models.results.ComercioResponse
import kotlinx.android.synthetic.main.fragment_bussines.*
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bussines, container, false)


        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}

        val okhttp = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS).apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
                }
            }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialadvisor.herokuapp.com/")
            .client(okhttp.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val service = retrofit.create(SocialAdviserApi::class.java)

        val call = service.getAllComercios()

        call.enqueue(object : Callback<ComercioResponse>{
            override fun onResponse(
                call: Call<ComercioResponse>,
                response: Response<ComercioResponse>
            ) {
                val comercios:ComercioResponse? = response.body()

                val com = comercios?.results

                val come = ArrayList<Comercios>()

                if (com!= null){
                    for(comercios in com){
                        come.add(comercios)
                    }
                }


                recycler_bussiness.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = RecyclerBusinessAdapter(come)
                }

            }

            override fun onFailure(call: Call<ComercioResponse>, t: Throwable) {
            }

        })

        view.floatingActionButtonSummary.setOnClickListener {
                this.findNavController().navigate(
                    BussinesFragmentDirections.actionToSummary()
                )

        }

        return view
    }

}