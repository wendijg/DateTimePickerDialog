package com.example.escuestas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.Data.ListEncuestas
import com.example.escuestas.Email.Companion.validarCorreo
import com.example.escuestas.Entity.EntityEncuesta
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_encuesta.*

class QuizActivity : AppCompatActivity() {


    val mispelotas =ListEncuestas()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encuesta)

        btnEnviar.setOnClickListener {


            val miencuesta = EntityEncuesta()
            if (edtNombreE.text.toString().trim().isNotEmpty()) {
                miencuesta.nombre = edtNombreE.text.toString()
                if (edtApellidoPaternoE.text.toString().trim().isNotEmpty()) {
                    miencuesta.ApellidoMaterno = edtApellidoPaternoE.text.toString()

                    if (edtApellidoMaternoE.text.toString().trim().isNotEmpty()) {
                        miencuesta.ApellidoMaterno = edtApellidoMaternoE.text.toString()

                        if ((etdCorreoE.text.toString().trim().isNotEmpty()) and (validarCorreo(etdCorreoE.text.toString().trim().toString()))){
                            miencuesta.correo = etdCorreoE.text.toString()
                            val generoposition = spnGeneroE.selectedItemPosition

                            if (generoposition > 0){
                                miencuesta.genero = generoposition
                                val genero = spnGeneroE.getSelectedItemId().toString()
                                Log.d("udelp","Seleccionaste Genero $genero")
                                val aeropatitoposition = spnAero.selectedItemPosition
                                if (aeropatitoposition > 0){

                                    miencuesta.viajado = aeropatitoposition

                                    val frecuenciaposition = spnFrecuencia.selectedItemPosition

                                    if (frecuenciaposition > 0){
                                        miencuesta.frecuencia = frecuenciaposition
                                        val experienciaposition =spnExperiencia.selectedItemPosition
                                        if (experienciaposition > 0){
                                            miencuesta.experiencia = experienciaposition

                                            val selectedServicio = rdgServicios.checkedRadioButtonId
                                            if (selectedServicio != -1){
                                                when(selectedServicio){
                                                    rdbExcelente.id->{
                                                        miencuesta.servicio = "Excelente"
                                                    }
                                                    rdbBueno.id->{
                                                        miencuesta.servicio  = "Bueno"
                                                    }
                                                    rdbMalo.id->{
                                                        miencuesta.servicio  = "Malo"
                                                    }
                                                }

                                                if((ckbEconomica.isChecked) or (ckbEjecutiva.isChecked) or (ckbPromo.isChecked)){

                                                    if(ckbEconomica.isChecked){
                                                        miencuesta.economica = true
                                                    }
                                                    if(ckbPromo.isChecked){
                                                        miencuesta.promo = true
                                                    }
                                                    if(ckbEjecutiva.isChecked){
                                                        miencuesta.ejecutiva = true
                                                    }

                                                    Log.d("udelp",miencuesta.correo)
                                                    if(swtOfertasDescuentos.isChecked){
                                                        miencuesta.ofertas =true
                                                    }
                                                    miencuesta.mejora = edtMejorar.text.toString()
                                                    Toast.makeText(this@QuizActivity,"Encuesta Guardada",Toast.LENGTH_SHORT).show()


                                                    limpiar()

                                                    Log.d("tamañoLISTA",mispelotas.agregarEncuesta(miencuesta).toString())


                                                }else{
                                                    Snackbar.make(it,"Selecciona el tipo de squema usaste ",Snackbar.LENGTH_SHORT).show()
                                                }

                                            }else{
                                                Snackbar.make(it,"Selecciona servicio",Snackbar.LENGTH_SHORT).show()
                                            }


                                        }else{
                                            Snackbar.make(it,"Selecciona tu experiencia",Snackbar.LENGTH_SHORT).show()
                                        }

                                    }else{
                                        Snackbar.make(it, "selecciona la frecuencia", Snackbar.LENGTH_SHORT).show()
                                    }

                                }else{
                                    Snackbar.make(it, "selecciona si has viajado ", Snackbar.LENGTH_SHORT).show()
                                }


                            }else{
                                Snackbar.make(it, "selecciona Genero", Snackbar.LENGTH_SHORT).show()
                            }


                        }else{
                            Snackbar.make(it, "ingresa el Correo", Snackbar.LENGTH_SHORT).show()
                        }


                    } else {
                        Snackbar.make(it, "ingresa el Apellido Materno", Snackbar.LENGTH_SHORT).show()
                    }



                } else {
                    Snackbar.make(it, "ingresa el Apellido Paterno", Snackbar.LENGTH_SHORT).show()
                }


            } else {
                Snackbar.make(it, "Por favor ingresa el nombre", Snackbar.LENGTH_SHORT).show()
            }


        }
    }

    fun limpiar(){
        edtNombreE.text.clear()
        edtApellidoPaternoE.text.clear()
        edtApellidoMaternoE.text.clear()
        etdCorreoE.text.clear()
        spnGeneroE.setSelection(0)
        spnAero.setSelection(0)
        spnFrecuencia.setSelection(0)
        spnExperiencia.setSelection(0)
        ckbEconomica.isChecked = false
        ckbPromo.isChecked = false
        ckbEjecutiva.isChecked = false
        rdgServicios.clearCheck()
        edtMejorar.text.clear()
        swtOfertasDescuentos.isChecked = false

    }

    /*
    fun validarNombre() {
    if (edtNombreE.text.toString().trim().isNotEmpty()) {
        encuesta.nombre = edtNombreE.text.toString()
        //Toast.makeText(this@RealizarEncuestaActivity,"Que transa si le metiste datos",Toast.LENGTH_LONG).show()
        // Snackbar.make(it, "Que transa si le metiste datos", Snackbar.LENGTH_SHORT).show()
        //Aqui marcara error hasta tener la clase kotlin encuesta
        // val encuesta.nombre = edtNombreE.text.toString()
        //------------------Anidando if para que si el nombre esta lleno se siga al siguiente campo


    } else {
        //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
        Toast.makeText(this@QuizActivity, "Inserte nombre", Toast.LENGTH_SHORT).show()


    }


}

fun validarApellidoP() {
    if (edtApellidoPaternoE.text.toString().trim().isNotEmpty()) {
        encuesta.ApellidoPaterno = edtApellidoPaternoE.text.toString()
        // val encuesta.ApellidoPaternoE = edtApellidoPaternoE.text.toString()

    } else {
        //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
        Toast.makeText(this@QuizActivity, "Inserte Apellido paterno", Toast.LENGTH_SHORT)
            .show()
    }

}
fun validarApellidoM() {
    if (edtApellidoMaternoE.text.toString().trim().isNotEmpty()) {
        encuesta.ApellidoMaterno = edtApellidoMaternoE.text.toString()
        // val encuesta.ApellidoMaternoE = edtApellidoPaternoE.text.toString()

    } else {
        //Toast.makeText(this@RealizarEncuestaActivity,"Te dije que le metieras datos culo",Toast.LENGTH_LONG).show()
        Toast.makeText(this@QuizActivity, "Inserte Apellido materno", Toast.LENGTH_SHORT).show()

    }
}

fun validarCorre(){

    if (etdCorreoE.text.toString().trim().isNotEmpty()) {
        encuesta.correo = etdCorreoE.text.toString()
        // val encuesta.correo = edtCorreo.text.toString()

    }else {
        Toast.makeText(this@QuizActivity, "Inserte correo", Toast.LENGTH_SHORT).show()

    }

}

fun validarGenero() {

    val generoposition = spnGeneroE.selectedItemPosition

    if (generoposition > 0) {
        encuesta.genero = spnGeneroE.getSelectedItemPosition()

        //val encuesta.genero = spnGeneroE.getSelectedItemId().toString()
        val genero = spnGeneroE.getSelectedItemId().toString()
    }else {
        Toast.makeText(this@QuizActivity, "Inserte genero", Toast.LENGTH_SHORT).show()

    }


}


fun validarViajado(){
    val aeropatitoposition = spnAero.selectedItemPosition
    if (aeropatitoposition > 0) {
        encuesta.viajado = spnAero.getSelectedItemPosition()
    } else {
        Toast.makeText(this@QuizActivity, "Inserte viajes", Toast.LENGTH_SHORT).show()

    }


}

fun validarFrecuencia(){
    val frecuenciaposition = spnFrecuencia.selectedItemPosition

    if (frecuenciaposition > 0) {
        encuesta.frecuencia =
            spnFrecuencia.getSelectedItemPosition()
    }else {
        Toast.makeText(this@QuizActivity, "Inserte frecuencia", Toast.LENGTH_SHORT).show()

    }



}

fun validarExperiencia(){

    val experienciaposition =
        spnExperiencia.selectedItemPosition
    if (experienciaposition > 0) {
        encuesta.experiencia =
            spnExperiencia.getSelectedItemPosition()

    }else {
        Toast.makeText(this@QuizActivity, "Inserte experiencia", Toast.LENGTH_SHORT).show()

    }
}

fun validarEsquemaEjecutiva(){
    if (ckbEjecutiva.isChecked) {
        encuesta.ejecutiva = true
    }else {
        Toast.makeText(this@QuizActivity, "Inserte esquema", Toast.LENGTH_SHORT).show()

    }

}

fun validarEsquemaEconomica(){

    if (ckbEconomica.isChecked) {
        encuesta.economica = true


    }else {
        Toast.makeText(this@QuizActivity, "Inserte esquema", Toast.LENGTH_SHORT).show()

    }
}
fun validarEsquemaPromo(){
    if (ckbPromo.isChecked) {
        encuesta.promo = true
    }   else {
        Toast.makeText(this@QuizActivity, "Inserte esquema", Toast.LENGTH_SHORT).show()

    }


}

fun validarServicio(){
    val selectedServicio =
        rdgServicios.checkedRadioButtonId
    if (selectedServicio != -1) {
        when (selectedServicio) {
            rdbExcelente.id -> {
                encuesta.servicio = "Excelente"

            }
            rdbBueno.id ->{
                encuesta.servicio="Bueno"
            }
            rdbMalo.id ->{
                encuesta.servicio="Malo"
            }
        }
    }else{
        Toast.makeText(this@QuizActivity, "Inserte servicio", Toast.LENGTH_SHORT).show()

    }

}


fun validarOfertasDescuento(){

    if (swtOfertasDescuentos.isChecked) {
        encuesta.ofertas = true
        Toast.makeText(
            this@QuizActivity,
            "Elemento guardado",
            Toast.LENGTH_SHORT
        ).show()
    }
}

     */






}