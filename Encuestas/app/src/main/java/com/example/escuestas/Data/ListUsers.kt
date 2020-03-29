package com.example.escuestas.Data

import android.util.Log
import com.example.escuestas.Entity.EntityUser

class ListUsers {
    companion object {
        val listUsers = arrayListOf<EntityUser>()

        private val lista= arrayListOf<String>()
    }


    /* public fun agregarUsuario(nombre:String,ApellidoP:String,ApellidoM:String,telefono:Int,genero:Int,delegacion:Int,
                               direccion:String,estadoCivil:Int,correo:String,password:String){

         listaUsuario.add(nombre)
         listaUsuario.add(ApellidoP)
         listaUsuario.add(ApellidoM)
         listaUsuario.add(telefono.toString())
         listaUsuario.add(genero.toString())
         listaUsuario.add(delegacion.toString())
         listaUsuario.add(direccion)
         listaUsuario.add(estadoCivil.toString())
         listaUsuario.add(correo)
         listaUsuario.add(password)

     }
     */


    public fun agregarU(user:EntityUser): Int{
        listUsers.add(user)

        Log.d("UDELP","$user")

        return listUsers.size
    }
    public fun encontrarU(login: EntityUser): Int {
        var encontrado =- 1
        for (user in listUsers){
            if(login.nombre == user.nombre && login.password == user.password){
                encontrado = 1
            }
        }
        return encontrado

    }



}