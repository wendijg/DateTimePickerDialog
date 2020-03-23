package com.example.basedatostest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.basedatostest.Data.StudentEntity
import com.example.basedatostest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_delete.*

class Delete : AppCompatActivity() {

    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        btnAceptar.setOnClickListener {

            val student = StudentEntity()
            val idStudent = edtId.text.toString()
            student.id = idStudent.toInt()

            studentsDb.studentDelete(student.id)
            limpiar()

            studentsDb.studentGetAll()
            Toast.makeText(this@Delete, "Elemento eliminado", Toast.LENGTH_SHORT).show()
        }
    }
    fun limpiar() {
        edtId!!.text.clear()
    }
}
