package com.example.basedatostest.Data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConnectionDb(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE_STUDENTS)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE_STUDENTS)
    }

    fun OpenConnection(typeConectionDb: Int):SQLiteDatabase{
        return when (typeConectionDb){
            MODE_WRITE ->
                return writableDatabase
            MODE_READ ->
                return readableDatabase
            else ->
                return  readableDatabase
        }
    }

    companion object{

        const val DATABASE_NAME = "UNIVERSIDAD"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME_STUDENTS="CTL_ESTUDIANTES"
        const val CREATE_TABLE_STUDENTS="CREATE TABLE $TABLE_NAME_STUDENTS(Id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(20),Lastname VARCHAR(15),Gender INTERGER,Birthday DATE)"
        const val DROP_TABLE_STUDENTS="DROP TABLE IF EXISTS $TABLE_NAME_STUDENTS"
        const val MODE_WRITE=1
        const val MODE_READ=2
    }
}