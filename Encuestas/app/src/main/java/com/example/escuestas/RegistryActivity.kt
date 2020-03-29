package com.example.escuestas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.escuestas.Data.ListUsers
import com.example.escuestas.Email.Companion.validarCorreo
import com.example.escuestas.Entity.EntityUser
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_encuesta.*
import kotlinx.android.synthetic.main.activity_registro.*

class RegistryActivity : AppCompatActivity() {

    val registroUsuario = ListUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        btnAceptar.setOnClickListener {
            val usuario = EntityUser()

            if(edtNombreRegistro.text.toString().trim().isNotEmpty()){
                usuario.nombre = edtNombreRegistro.text.toString()

                if(edtApellidoPaternoR.text.toString().trim().isNotEmpty()){
                    usuario.ApellidoPaterno = edtApellidoPaternoR.text.toString()

                    if(edtApellidoMaternoR.text.toString().trim().isNotEmpty()){
                        usuario.ApellidoMaterno = edtApellidoMaternoR.text.toString()

                        if(edtTelefonoR.text.toString().trim().isNotEmpty()){
                            usuario.telefono = edtTelefonoR.text.toString()

                            val selectedServicio = rdgGenero.checkedRadioButtonId
                            if (selectedServicio != -1) {
                                when (selectedServicio) {
                                    rdbMasculinoR.id -> {
                                        usuario.genero = "Masculino"
                                    }
                                    rdbFemeninoR.id -> {
                                        usuario.genero = "Femenino"
                                    }
                                }
                                val delegacionposition = spnDelegacionR.selectedItemPosition
                                if (delegacionposition > 0) {
                                    usuario.delegacion = delegacionposition

                                    val genero = spnDelegacionR.getSelectedItemId().toString()
                                    Log.d("udelp", "Seleccionaste Genero $genero")
                                    if(edtDireccionR.text.toString().trim().isNotEmpty()) {
                                        usuario.direccion = edtDireccionR.text.toString()

                                        val edoCivil = spnEstadoCivil.selectedItemPosition
                                        if (edoCivil > 0) {
                                            usuario.estadoCivil = edoCivil

                                            if((edtCorreoR.text.toString().trim().isNotEmpty()) and (validarCorreo(edtCorreoR.text.toString().trim().toString()))){
                                                usuario.correo = edtCorreoR.text.toString()

                                                if(edtContraseñaR.text.toString().trim().isNotEmpty()) {
                                                    usuario.password = edtContraseñaR.text.toString()
                                                    Toast.makeText(this@RegistryActivity,"Usuario Guardado",Toast.LENGTH_SHORT).show()
                                                    Log.d("tamañoLISTA",registroUsuario.agregarU(usuario).toString())

                                                }else{
                                                    Snackbar.make(it, "Por favor ingrese contraseña", Snackbar.LENGTH_SHORT).show()
                                                }
                                            }else{
                                                Snackbar.make(it, "Por favor ingrese correo electrónico", Snackbar.LENGTH_SHORT).show()
                                            }
                                        }else{
                                            Snackbar.make(it, "Por favor seleccione estado civil", Snackbar.LENGTH_SHORT).show()
                                        }
                                    }else{
                                        Snackbar.make(it, "Por favor ingresa una dirección", Snackbar.LENGTH_SHORT).show()
                                    }
                                }else{
                                    Snackbar.make(it, "Por favor seleccione el genero", Snackbar.LENGTH_SHORT).show()
                                }
                            }else{
                                Snackbar.make(it, "Por favor seleccione la delegación", Snackbar.LENGTH_SHORT).show()
                            }
                        }else{
                            Snackbar.make(it, "Por favor ingresa el teléfono", Snackbar.LENGTH_SHORT).show()
                        }
                    }else{
                        Snackbar.make(it, "Por favor ingresa el apellido materno", Snackbar.LENGTH_SHORT).show()
                    }
                }else{
                    Snackbar.make(it, "Por favor ingresa el apellido paterno", Snackbar.LENGTH_SHORT).show()
                }
            }else{
                Snackbar.make(it, "Por favor ingresa el nombre", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
    /*
    fun limpiar(){
        edtNombreRegistro.text.clear()
        edtApellidoPaternoR.text.clear()
        edtApellidoMaternoR.text.clear()
        edtTelefonoR.text.clear()
        rdbMasculinoR.cle
        rdbFemeninoR
        spnDelegacionR
        edtDireccionR
        spnEstadoCivil
        edtCorreoR
        edtContraseñaR
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

    }*/


        }
