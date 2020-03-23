package com.example.basedatostest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import com.example.basedatostest.Data.StudentEntity
import com.example.basedatostest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_update.*
import java.util.*

class Update : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        btnAceptar.setOnClickListener {

            val student = StudentEntity()
            val idStudent = edtId.text.toString()
            student.id = idStudent.toInt()
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
                Toast.makeText(this@Update, msg, Toast.LENGTH_SHORT).show()
            }

            var values = StudentEntity(student.id, student.name, student.lastName, student.gender, student.birthday)
            var id = studentsDb.studentEdit(values)
            limpiar()
            Toast.makeText(this@Update, "Elemento editado", Toast.LENGTH_SHORT).show()
            studentsDb.studentGetAll()
        }

    }

    fun limpiar() {
        edtId!!.text.clear()
        edtName!!.text.clear()
        edtLastName!!.text.clear()
        spnGender!!.setSelection(0)
    }
}
