package com.sibaamap.sqlitekotlin.databse

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.util.*
import kotlin.collections.ArrayList

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
        companion object{
            private const val DATABASE_VERSION = 1
            private const val DATABASE_NAME = "EmployeeDatabase"

            private const val TABLE_CONTACTS = "EmployeeTable"

            private const val KEY_ID = "_id"
            private const val KEY_NAME = "name"
            private const val KEY_EMAIL = "email"
        }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")")
        db?.execSQL(CREATE_CONTACTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_CONTACTS")
        onCreate(db)
    }
    fun addEmployee(emp: EmpModelClass): Long{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(KEY_NAME, emp.name)
        contentValues.put(KEY_EMAIL, emp.email)

        val success = db.insert(TABLE_CONTACTS,null,contentValues)

        db.close()
        return success
    }
    fun viewEmployee(): ArrayList<EmpModelClass>{
        val empList: ArrayList<EmpModelClass> = ArrayList<EmpModelClass>()
        // Query to select all the records from the table.
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"

        val db = this.readableDatabase
        // Cursor is used to read the record one by one. Add them to data model class.
        val cursor: Cursor? = null
        return empList

    }
}
