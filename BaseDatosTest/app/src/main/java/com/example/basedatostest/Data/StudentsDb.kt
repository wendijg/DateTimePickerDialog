package com.example.basedatostest.Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log

class StudentsDb {

    private var connectionDb:ConnectionDb
    private lateinit var sqliteDataBase:SQLiteDatabase

    constructor(context:Context){
        connectionDb = ConnectionDb(context)
    }

    fun studentAdd(student:StudentEntity): Long{

        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME, student.name)
        values.put(LASTNAME, student.lastName)
        values.put(GENDER, student.gender)
        values.put(BIRTHDAY, student.birthday)

        return sqliteDataBase.insert(ConnectionDb.TABLE_NAME_STUDENTS, null, values)
    }

    fun studentEdit(student:StudentEntity): Int {

        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_WRITE)

        val values = ContentValues()
        values.put(NAME, student.name)
        values.put(LASTNAME, student.lastName)
        values.put(GENDER, student.gender)
        values.put(BIRTHDAY, student.birthday)
        var selection = "Id=?"
        var args = arrayOf(student.id.toString())

        return sqliteDataBase.update(ConnectionDb.TABLE_NAME_STUDENTS, values, selection, args)
    }

    fun studentDelete(idStudent:Int): Int {
        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_WRITE)
        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())
        return sqliteDataBase.delete(ConnectionDb.TABLE_NAME_STUDENTS, selection, args)
    }

    fun studentGetAll(){
        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_READ)
        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)

        val cursor = sqliteDataBase.query(ConnectionDb.TABLE_NAME_STUDENTS, fields, null, null, null, null, null)

        if (cursor.moveToFirst()){
            do{
                Log.d("UDELP", "${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(3)} ${cursor.getString(4)}")
            }while(cursor.moveToNext())
        }
    }

    public fun returnListStudents():Array<String>{
        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_READ)
        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)

        val cursor = sqliteDataBase.query(ConnectionDb.TABLE_NAME_STUDENTS, fields, null, null, null, null, null)

        if (cursor.moveToFirst()){
            do{
                listStudents.add(cursor.getInt(1), cursor.getString(1))
            }while(cursor.moveToNext())
        }

        val elems = listStudents
        return elems.toTypedArray()
    }

    fun studentGetOne(idStudent:Int){
        sqliteDataBase = connectionDb.OpenConnection(ConnectionDb.MODE_READ)
        val fields = arrayOf(ID, NAME, LASTNAME, GENDER, BIRTHDAY)
        var selection = "Id=?"
        var args = arrayOf(idStudent.toString())
        val cursor = sqliteDataBase.query(ConnectionDb.TABLE_NAME_STUDENTS, fields, selection, args, null, null, null)

        if (cursor.moveToFirst()){
                Log.d("UDELP", "${cursor.getInt(0)} ${cursor.getString(1)} ${cursor.getString(2)} ${cursor.getInt(3)} ${cursor.getString(4)}")
        }
    }


    companion object{

        val listStudents = arrayListOf<String>()

        const val ID = "Id"
        const val NAME = "Name"
        const val LASTNAME = "Lastname"
        const val GENDER = "Gender"
        const val BIRTHDAY = "Birthday"
    }

}