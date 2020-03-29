package com.example.escuestas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.Data.ListEncuestas
import com.example.escuestas.Data.ListEncuestas.Companion.listEncuesta
import com.example.escuestas.Entity.EntityEncuesta
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    val encuesta= ListEncuestas()
    var encuestaS = EntityEncuesta()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        val position = intent.extras?.getString("ID")

        if (position != null) {
            encuestaS = listEncuesta[position.toInt()]
        }
        edtNombreE.setText("${encuestaS.nombre.toString()}")
        edtApellidosEditar.setText("${encuestaS.ApellidoPaterno.toString()} ${encuestaS.ApellidoMaterno.toString()}")
        etdCorreoEditar.setText("${encuestaS.correo.toString()}")
        var genero=""
        if (encuestaS.genero == 1) {
            genero = "Masculino"
        } else {
            genero = "Femenino"
        }
        txtvGeneroEditar.setText("$genero")
        btnEnviar.setOnClickListener {


            var viajado = ""
            var frecuencia = ""
            var exp = ""
            var ofertas = ""


            val aeropatitoposition = spnAero.selectedItemPosition
            if (aeropatitoposition > 0) {
                encuestaS.viajado = aeropatitoposition

                val frecuenciaposition = spnFrecuencia.selectedItemPosition
                if (frecuenciaposition > 0) {
                    encuestaS.frecuencia = frecuenciaposition
                    val experienciaposition = spnExperiencia.selectedItemPosition
                    if (experienciaposition > 0) {
                        encuestaS.experiencia = experienciaposition

                        val selectedServicio = rdgServicios.checkedRadioButtonId
                        if (selectedServicio != -1) {
                            when (selectedServicio) {
                                rdbExcelente.id -> {
                                    encuestaS.servicio = "Excelente"
                                }
                                rdbBueno.id -> {
                                    encuestaS.servicio = "Bueno"
                                }
                                rdbMalo.id -> {
                                    encuestaS.servicio = "Malo"
                                }
                            }//fin when
                            if ((ckbEconomica.isChecked) or (ckbEjecutiva.isChecked) or (ckbPromo.isChecked)) {
                                //val encuesta.aqui ver los checkbox = True
                                if(ckbEconomica.isChecked){
                                    encuestaS.economica = true
                                }
                                if(ckbPromo.isChecked){
                                    encuestaS.promo = true
                                }
                                if(ckbEjecutiva.isChecked){
                                    encuestaS.ejecutiva = true
                                }
                                Log.d("udelp", encuestaS.correo)
                                if (swtOfertasDescuentos.isChecked) {
                                    encuestaS.ofertas = true
                                }
                                encuestaS.mejora = edtMejorar.text.toString()
                                Toast.makeText(this@EditActivity,"Editado",Toast.LENGTH_SHORT).show()

                                if (position != null) {
                                    Log.d("tamañoLISTA",encuesta.editar(position.toInt(),encuestaS).toString())
                                }



                            } else {
                                Snackbar.make(it,"Selecciona que tipo de esquema usaste ", Snackbar.LENGTH_SHORT).show()

                            }
                        }else{
                            Snackbar.make(it,"Selecciona como es nuestro servicio",Snackbar.LENGTH_SHORT).show()
                        }
                    }else{
                        Snackbar.make(it,"Selecciona tu experiencia",Snackbar.LENGTH_SHORT).show()
                    }
                }else{
                    Snackbar.make(it, "Por favor selecciona la frecuencia", Snackbar.LENGTH_SHORT).show()
                }
            } else{
                Snackbar.make(it, "Por favor selecciona si has viajado con nosotros", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

}
