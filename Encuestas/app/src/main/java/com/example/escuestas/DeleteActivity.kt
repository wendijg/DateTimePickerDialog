package com.example.escuestas

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.R

import com.example.escuestas.Entity.EntityEncuesta
import com.example.escuestas.Data.ListEncuestas
import kotlinx.android.synthetic.main.activity_delete.*

import kotlinx.android.synthetic.main.activity_misencuestas.ltvEncuestas

class DeleteActivity : AppCompatActivity(){
    var listaEncuestas = ListEncuestas()
   // var estoesunaprueba = ListEncuestas()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)
        if (listaEncuestas.devuelveListEncuesta().size > 0) {

            val adaptador = ArrayAdapter<String>(this@DeleteActivity, android.R.layout.simple_list_item_1, listaEncuestas.devuelveListEncuestaString())
            ltvEncuestasDEL.adapter = adaptador

            ltvEncuestasDEL.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
                val itemSeleccionado = adapterView.getItemAtPosition(position)
                Toast.makeText(this@DeleteActivity,"$position $id $itemSeleccionado",Toast.LENGTH_SHORT).show()
                miDialogo("Eliminar a $itemSeleccionado", id.toInt()).show()
            }
        }
    }

    private fun miDialogo(texto:String , id:Int): android.app.AlertDialog {
        val miAlerta = android.app.AlertDialog.Builder(this@DeleteActivity)
        miAlerta.setTitle("Cuidado !! quieres continuar eliminandor?").setMessage(texto)
        miAlerta.setPositiveButton("SI") { dialog, which ->
            listaEncuestas.EliminaEsta(id)
            Toast.makeText(this@DeleteActivity, "Se elimino", Toast.LENGTH_SHORT).show()

            finish();
            startActivity(intent);
        }

        miAlerta.setNegativeButton("NO") { dialog, which ->
            Toast.makeText(this@DeleteActivity, "Se cancelo", Toast.LENGTH_SHORT).show()
        }
        return miAlerta.create()
    }


}