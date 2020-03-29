package com.example.escuestas

import android.content.Intent
import android.os.Bundle
import com.example.escuestas.Entity.EntityEncuesta
import kotlinx.android.synthetic.main.activity_detail.*
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.Data.ListEncuestas.Companion.listEncuesta



class DetailActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val position = intent.extras?.getString("ID")
        val numEncuesta = ((position?.toInt())?.plus((1)))
        txvNumeroEncuesta.setText(":${numEncuesta.toString()}")
        var encuesta = EntityEncuesta()
        encuesta = listEncuesta[position!!.toInt()]
        var genero =""
        var viajado=""
        var frecuencia=""
        var exp=""
        var ofertas=""
        txvNombreDetalle.setText("${encuesta.nombre.toString()}")
        txvNumeroEncuesta.setText(":${position+1.toString()}")
        txvApellidoPaternoDetalle.setText("${encuesta.ApellidoPaterno.toString()}")
        txvApellidoMaternoDetalle.setText("${encuesta.ApellidoMaterno.toString()}")
        txvCorreoDetalle.setText("${encuesta.correo.toString()}")
         if(encuesta.genero==1){
            genero= "Masculino"
             }else{
            genero= "Femenino"
             }
        txvGeneroDetalle.setText("$genero")
        if(encuesta.viajado==1){
            viajado= "Si ha viajadado en AeroPatito"
             }else{
            viajado= "No he viajado en AeroPatito"
        }
        txvViajadoDetalle.setText("$viajado")
        when(encuesta.frecuencia){
            1->{
                frecuencia = "1 a 3 veces al año"
            }
            2->{
                frecuencia = "4 a 7 veces al año"
            }
            3->{
                frecuencia = "Más de 7 veces al año"
            }
        }
        txvFrecuenciaDetalle.setText("$frecuencia")
        when(encuesta.experiencia){
            1->{
                exp="Mala"
            }
            2->{
                exp="Regular"
            }
            3->{
                exp="Buena"
            }
            4->{
                exp="Excelente"
            }
        }
        txvExperienciaDetalle.setText("$exp")
        var esquema = ""
        if(encuesta.economica == true){
            esquema += "Económica "
        }
        if(encuesta.promo == true){
            esquema += "Promo "
        }
        if(encuesta.ejecutiva){
            esquema += "Ejecutiva "
        }

        txvEsquemaDetalle.setText("$esquema")
        txvServicioDetalle.setText("${encuesta.servicio.toString()}")
        txvMejorasDetalle.setText("${encuesta.mejora.toString()}")

        if(encuesta.ofertas==true){
            ofertas = "Quiero recibir ofertas y descuentos"
        }else{
            ofertas = "No quiero recibir ofertas y descuentos"
        }
        txvOfertasDescuentosDetalle.setText("$ofertas")
    }
}