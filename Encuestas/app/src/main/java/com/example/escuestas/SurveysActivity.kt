package com.example.escuestas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.Data.ListEncuestas
import kotlinx.android.synthetic.main.activity_misencuestas.*

//mis encuestas
class SurveysActivity : AppCompatActivity() {

    var ListEncuestas = ListEncuestas()
    var Lista2 = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misencuestas)



        if(ListEncuestas.devuelveListEncuesta().size >0){
            val miAdaptador = ArrayAdapter<String> (this@SurveysActivity,
                android.R.layout.simple_list_item_1,ListEncuestas.devuelveListEncuestaString())
            ltvEncuestas.adapter=miAdaptador

            ltvEncuestas.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                val itemSeleccionado = adapterView.getItemAtPosition(position)
                Toast.makeText(
                    this@SurveysActivity,
                    "$position $id $itemSeleccionado",
                    Toast.LENGTH_SHORT
                ).show()

                val intent = Intent(this@SurveysActivity, DetailActivity::class.java)
                intent.putExtra("ID", position.toString())
                startActivity(intent)
            }
        }



    }
}