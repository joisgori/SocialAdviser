package com.example.socialadviser.fragments_logic

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.ColaAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.Cola
import com.example.socialadviser.models.results.CitasResponse
import com.example.socialadviser.models.results.ColaResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_cola.*
import kotlinx.android.synthetic.main.fragment_cola.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


class ColaFragment : Fragment() {

    lateinit var email:String
    lateinit var pass:String
    lateinit var adapter: ColaAdapter
    lateinit var clienteFi : Cliente2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cola, container, false)

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

        val call = service.getAllColas()

        val user = service.login(email, pass)

        user.enqueue(object : Callback<Cliente2> {
            override fun onResponse(call: Call<Cliente2>, response: Response<Cliente2>) {
                if(response.code() == 200){
                    clienteFi = response.body()!!
                }
            }

            override fun onFailure(call: Call<Cliente2>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        })

        call.enqueue(object : Callback<ColaResponse>{
            override fun onResponse(call: Call<ColaResponse>, response: Response<ColaResponse>) {

                val colas:ColaResponse? = response.body()

                val col = colas?.results

                val recyclerView = view.recycler_colas

                adapter = object : ColaAdapter(view.context){
                    override fun setClickListenerToSummaryCola(holder: ViewHolder, item: Cola) {
                        holder.itemView.setOnClickListener {
                            val nextAction = ColaFragmentDirections.actionColaFragmentToColaSummary(item, clienteFi)
                            Navigation.findNavController(it).navigate(nextAction)
                        }
                    }

                }

                adapter.changeDataSet(col!!)

                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(view.context)

            }

            override fun onFailure(call: Call<ColaResponse>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

        return view
    }


}