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
import com.example.socialadviser.adapters.RecyclerAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cliente2
import com.example.socialadviser.models.results.CitasResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_meeting.*
import kotlinx.android.synthetic.main.fragment_meeting.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

lateinit var clienteF : Cliente2

class MeetingFragment : Fragment(){

    lateinit var email:String
    lateinit var pass:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meeting, container, false)


        val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY}

        val okhttp = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS).apply {
                if (BuildConfig.DEBUG) {
                    addInterceptor(logging)
                }
            }

        email = activity?.intent?.extras?.getString("mail")!!
        pass = activity?.intent?.extras?.getString("contra")!!

        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://socialadvisor.herokuapp.com/")
            .client(okhttp.build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val service = retrofit.create(SocialAdviserApi::class.java)

        val call = service.getAllCitas()

        val user = service.login(email, pass)

        user.enqueue(object : Callback<Cliente2>{
            override fun onResponse(call: Call<Cliente2>, response: Response<Cliente2>) {
                if(response.code() == 200){
                    clienteF = response.body()!!
                }
            }

            override fun onFailure(call: Call<Cliente2>, t: Throwable) {
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        })

        call.enqueue(object : Callback<CitasResponse>{
            override fun onResponse(call: Call<CitasResponse>, response: Response<CitasResponse>) {

                val citas:CitasResponse?= response.body()

                val cit = citas?.results

                Log.d("Citas", cit.toString())

                recycler_meetings.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = cit?.let {
                        RecyclerAdapter(it)
                    }
                }
            }

            override fun onFailure(call: Call<CitasResponse>, t: Throwable) {
                Log.d("Error", t.message.toString())
            }

        })

        view.floatingActionButtonNewMeet.setOnClickListener{
            val nextAction = MeetingFragmentDirections.actionToNewMeet(clienteF)
            Navigation.findNavController(it).navigate(nextAction)
        }

        return view
    }


}
