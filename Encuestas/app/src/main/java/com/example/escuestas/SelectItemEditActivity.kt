package com.example.escuestas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_select_item_edit.*

class SelectItemEditActivity : AppCompatActivity(){
    var listaEncuestas = com.example.escuestas.Data.ListEncuestas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_item_edit)
        if(listaEncuestas.devuelveListEncuesta().size >0){
            val miAdaptador = ArrayAdapter<String> (this@SelectItemEditActivity, android.R.layout.simple_list_item_1,listaEncuestas.devuelveListEncuestaString())

            ltvEditarEncuesta.adapter=miAdaptador

            ltvEditarEncuesta.setOnItemClickListener {
                    adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                val itemSeleccionado = adapterView.getItemAtPosition(position)
                Toast.makeText(this@SelectItemEditActivity,"$position $id $itemSeleccionado", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@SelectItemEditActivity, EditActivity::class.java)
                intent.putExtra("ID", position.toString())
                startActivity(intent)
            }
        }
    }




}