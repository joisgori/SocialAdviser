package com.example.socialadviser.fragments_logic

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.socialadviser.R
import kotlinx.android.synthetic.main.fragment_catalog.*
import kotlinx.android.synthetic.main.fragment_catalog.view.*
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.coroutines.delay
import java.text.DateFormat
import java.util.*

class CatalogFragment : Fragment(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

    //Para DatePicker
    //var listener: DatePickerDialog.OnDateSetListener? = null
    //var datepicker = datePicker_newMeet

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    private fun getDateTimeCalendar(){
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_catalog, container, false)

        /*
        button.isEnabled = false
        button.isClickable = false
         */

        view.Button_next_form.isEnabled = false

        view.Button_New_Meeting.setOnClickListener {
            getDateTimeCalendar()
            //Toast.makeText(requireContext(), "HOLAAAAa", Toast.LENGTH_SHORT).show()
            DatePickerDialog(requireContext(), this, year, month, day).show()

        }

        view.Button_Meet_Back.setOnClickListener{
            //Lógica para regresar al recycler
            this.findNavController().navigateUp()
        }

        view.Button_next_form.setOnClickListener {
            this.findNavController().navigate(
                CatalogFragmentDirections.actionToNewBusiness()
            )
        }


        return view
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateTimeCalendar()
        TimePickerDialog(requireContext(), this, hour, minute, true).show()
    }

    @SuppressLint("setTextI18n")
    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        textView4.text = "$savedDay-$savedMonth-$savedYear\n Hour: $savedHour Minute: $savedMinute"

        Button_next_form.isEnabled = true

    }
}