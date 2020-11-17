package com.example.socialadviser.fragments_logic

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.socialadviser.BuildConfig
import com.example.socialadviser.R
import com.example.socialadviser.adapters.RecyclerAdapter
import com.example.socialadviser.interfaces.SocialAdviserApi
import com.example.socialadviser.models.Cita
import com.example.socialadviser.models.results.CitasResponse
import kotlinx.android.synthetic.main.fragment_catalog.*
import kotlinx.android.synthetic.main.fragment_catalog.view.*
import kotlinx.android.synthetic.main.fragment_meeting.*
import kotlinx.android.synthetic.main.fragment_meeting.view.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.Month
import java.time.Year
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.collections.ArrayList


class MeetingFragment : Fragment(){

    lateinit var email:String
    lateinit var pass:String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_meeting, container, false)

        view.floatingActionButtonNewMeet.setOnClickListener{
            this.findNavController().navigate(
                MeetingFragmentDirections.actionToNewMeet()

            )

        }

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

        val call = service.getAllCitas()

        call.enqueue(object : Callback<CitasResponse>{
            override fun onResponse(call: Call<CitasResponse>, response: Response<CitasResponse>) {

                val citas:CitasResponse? = response.body()

                val cit = citas?.results

                Log.d("Si hay", citas.toString())

                val cita = ArrayList<Cita>()

                if(cit!= null){
                    for(citas in cit){
                        cita.add(citas)
                    }
                }
                if(cit!= null) {
                    for (citas in cit) {
                        Log.d("Se guarda", cit.toString())
                    }
                }
                Log.d("Citas: ", cita.toString())

                recycler_meetings.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = RecyclerAdapter(cita)
                }

            }

            override fun onFailure(call: Call<CitasResponse>, t: Throwable) {
            }

        })

        email = activity?.intent?.extras?.getString("mail")!!
        pass = activity?.intent?.extras?.getString("contra")!!

        //Toast.makeText(requireContext(), email, Toast.LENGTH_SHORT).show()


        return view
    }

}
