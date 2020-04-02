package com.example.datetimepickerdialogexample

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePickerDialog.setOnClickListener{

            var year:Int
            var month:Int
            var day:Int

            if(txvDatePickerDialog.text.toString().isEmpty()){
                val cal = Calendar.getInstance()
                year = cal.get(Calendar.YEAR)
                month = cal.get(Calendar.MONTH)
                day = cal.get(Calendar.DAY_OF_MONTH)
            }else{
                val myDate = txvDatePickerDialog.text.toString()
                val formatter = DateTimeFormatter.ofPattern("d-MM-yyyy")
                val date = LocalDate.parse(myDate, formatter)

                year = date.year
                month = date.monthValue -1
                day = date.dayOfMonth
            }

            var dpd = DatePickerDialog(this@MainActivity,DatePickerDialog.OnDateSetListener{ datePicker: DatePicker, y: Int, m: Int, d: Int ->

                val dayString = if(d !in 1..9){
                    d.toString()
                }else{
                    "0$d"
                }

                val monthString = if(m !in 0..9){
                    (m+1).toString()
                }else{
                    "0${m+1}"
                }

                txvDatePickerDialog.text = "$dayString-$monthString-$y"

            },year, month, day)
            dpd.show()
        }


        btnTimePickerDialog.setOnClickListener{

            var hourOfDay:Int
            var minute:Int

            if(txvTimePickerDialog.text.toString().isEmpty()){
                val cal = Calendar.getInstance()
                hourOfDay = cal.get(Calendar.HOUR_OF_DAY)
                minute = cal.get(Calendar.MINUTE)
            }else{
                val myTime = txvTimePickerDialog.text.toString()
                val formatter = DateTimeFormatter.ofPattern("H:mm")
                val time = LocalTime.parse(myTime, formatter)

                hourOfDay = time.hour
                minute = time.minute
            }

            val tpd = TimePickerDialog(this@MainActivity,TimePickerDialog.OnTimeSetListener{ timePicker: TimePicker, h: Int, m: Int ->

                val hourString = if(h !in 1..9){
                    h.toString()
                }else{
                    "0$h"
                }

                val minuteString = if(m !in 1..9){
                    m.toString()
                }else{
                    "0$m"
                }

                txvTimePickerDialog.text = "$hourString:$minuteString"

            }, hourOfDay, minute, true)
            tpd.show()
        }
    }
}
