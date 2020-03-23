package com.example.basedatostest

import android.app.DatePickerDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.basedatostest.Data.StudentEntity
import com.example.basedatostest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_registry.*
import java.util.*

class Registry : AppCompatActivity() {


    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registry)


        btnAceptar.setOnClickListener {

            val student = StudentEntity()
            student.name = edtName.text.toString()
            student.lastName = edtLastName.text.toString()
            student.gender = spnGender.getSelectedItemPosition()
            val generoTexto = spnGender.getSelectedItem().toString()
            val birthday = findViewById<DatePicker>(R.id.dpBirthday)
            val today = Calendar.getInstance()
            birthday.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH)

            ) { view, year, month, day ->
                val month = month + 1
                val msg = "You Selected: $day/$month/$year"
                Toast.makeText(this@Registry, msg, Toast.LENGTH_SHORT).show()
            }

            var values = StudentEntity(-1, student.name, student.lastName, student.gender, student.birthday)
            var id = studentsDb.studentAdd(values)
            limpiar()
            Log.d("UDELP", "El id del elemento guardado es $id")
            studentsDb.studentGetAll()
            Toast.makeText(this@Registry, "Elemento guardado", Toast.LENGTH_SHORT).show()
        }
    }

    fun limpiar() {
        edtName!!.text.clear()
        edtLastName!!.text.clear()
        spnGender!!.setSelection(0)
    }
}
