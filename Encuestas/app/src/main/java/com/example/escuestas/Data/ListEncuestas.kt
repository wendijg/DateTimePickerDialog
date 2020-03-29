package com.example.escuestas.Data

import android.util.Log
import com.example.escuestas.Entity.EntityEncuesta

class ListEncuestas {


    companion object {
        val listEncuesta = arrayListOf<EntityEncuesta>()
        private val listaEncuesta = arrayListOf<String>()
    }

    public fun EliminaEsta(id: Int){
        listEncuesta.removeAt(id)
    }


    public fun agregarEncuesta(encuestaR: EntityEncuesta): Int {

        listEncuesta.add(encuestaR)
        Log.d("Udelp realizar encuesta","$encuestaR")
        return listEncuesta.size
    }


    public fun editar(id:Int,encuestaE:EntityEncuesta){

        listEncuesta.set(id,encuestaE)


    }

    public fun agregarEncuestaR(encuestaR:EntityEncuesta): Int{

        //val encuestaR = EntityEncuesta(nombre,apellidoP,apellidoM,correo,genero,viajado,frecuencia,experiencia,ejecutiva,economica,promo,servicio,mejora,ofertas)
        listEncuesta.add(encuestaR)

        Log.d("encuestasUDELP","$encuestaR")

        return listEncuesta.size
    }

/* public fun eliminarEncuesta(nombre: String){
     for((index,item)in listaEncuesta.withIndex())
     {
         if(item == nombre){
             listaEncuesta.removeAt(index)
             break
         }
     }


 }

 public fun editarEncuesta(nombre: String,viajado: Int,frecuencia: Int,experiencia: Int,ejecutiva: Boolean,economica: Boolean,promo: Boolean,
                           servicio: String,mejora: String,ofertas: Boolean,viajadoN: Int,frecuenciaN: Int,experienciaN: Int,
                           ejecutivaN: Boolean,economicaN: Boolean, promoN: Boolean, servicioN: String,mejoraN: String,ofertasN: Boolean){



     for((index,item)in listaEncuesta.withIndex())
     {
         if(item == nombre){
             listaEncuesta[index] = viajadoN.toString()
             listaEncuesta[index] = frecuenciaN.toString()
             listaEncuesta[index] = experienciaN.toString()
             listaEncuesta[index] = ejecutivaN.toString()
             listaEncuesta[index] = economicaN.toString()
             listaEncuesta[index] = promoN.toString()
             listaEncuesta[index] = servicioN
             listaEncuesta[index] = mejoraN
             listaEncuesta[index] = ofertasN.toString()
         }
     }


 }
*/
 public fun muestraEncuesta(){
     for((index,item) in listEncuesta.withIndex()){
         Log.d("UDELP","$index $item")

     }
 }


    public fun devuelveListEncuesta(): Array<EntityEncuesta> {
        val elems = listEncuesta
        return elems.toTypedArray()

    }

    public fun devuelveListEncuestaString(): Array<String> {
        listaEncuesta.clear()
        for (entityEncuesta in listEncuesta) {
            listaEncuesta.add(entityEncuesta.nombre)

        }
        Log.d("Test", listaEncuesta[0])
        Log.d("Ultimo", listaEncuesta[listaEncuesta.size -1])
        val elems = listaEncuesta
        return elems.toTypedArray()

    }
   /* public fun eliminarEncuesta(nombre: String){
        for((index,item)in listaEncuesta.withIndex())
        {
            if(item == nombre){
                listaEncuesta.removeAt(index)
                break
            }
        }


    }*/



}