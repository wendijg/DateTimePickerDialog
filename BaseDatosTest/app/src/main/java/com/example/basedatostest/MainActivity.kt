package com.example.basedatostest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.basedatostest.Data.StudentEntity
import com.example.basedatostest.Data.StudentsDb

        /*var values = StudentEntity(-1, "Wendi", "Jimenez", 0, "1998/02/10")
        var id = studentsDb.studentAdd(values)
        Log.d("UDELP", "El id del elemento guardado es $id")
        studentsDb.studentGetOne(2)
        var values = StudentEntity(1, "Scarlet", "Stevens", 0, "1999/06/10")
        studentsDb.studentEdit(values)
        studentsDb.studentDelete(3)
        studentsDb.studentGetAll()*/

class MainActivity : AppCompatActivity() {


    val studentsDb = StudentsDb(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.itmRegistry->{
                val intent = Intent(this@MainActivity,Registry::class.java)
                startActivity(intent)
            }

            R.id.itmSeeAll->{
                val intent = Intent(this@MainActivity,SeeAll::class.java)
                startActivity(intent)
            }

            R.id.itmUpdate->{
                val intent = Intent(this@MainActivity,Update::class.java)
                startActivity(intent)
            }

            R.id.itmDelete->{
                val intent = Intent(this@MainActivity,Delete::class.java)
                startActivity(intent)
            }
        }
        return true
    }

}
