package com.example.basedatostest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import com.example.basedatostest.Data.ConnectionDb
import com.example.basedatostest.Data.StudentEntity
import com.example.basedatostest.Data.StudentsDb
import kotlinx.android.synthetic.main.activity_registry.*
import kotlinx.android.synthetic.main.activity_see_all.*

class SeeAll : AppCompatActivity() {

    //private var lisStudents:ArrayList<StudentEntity>?=null
    private val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_all)

        //val listInformation = arrayListOf<String>()

        val miAdaptador = ArrayAdapter<String>(this@SeeAll, android.R.layout.simple_list_item_1,
            studentsDb.returnListStudents())

        lvStudents.adapter = miAdaptador

        lvStudents.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, position: Int, id:Long ->
            val intent = Intent(this@SeeAll,Detail::class.java)
            intent.putExtra("ID", position.toString())

            startActivity(intent)
        }
    }

}
