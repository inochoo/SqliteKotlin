package com.sibaamap.sqlitekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.sibaamap.sqlitekotlin.databse.DatabaseHandler
import com.sibaamap.sqlitekotlin.databse.EmpModelClass
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAdd.setOnClickListener {
            addRecord()
        }
    }
    private fun addRecord(){
        val name = etName.text.toString()
        val email = etEmailId.text.toString()
        val databaseHandler: DatabaseHandler = DatabaseHandler(this)
        if(name.isNotEmpty() && email.isNotEmpty()){
            val status = databaseHandler.addEmployee(EmpModelClass(0,name,email))
            if(status > -1){
                Toast.makeText(applicationContext,"Record saved",Toast.LENGTH_SHORT).show()
                etName.text.clear()
                etEmailId.text.clear()
            }
        }else{
            Toast.makeText(applicationContext,"Name or Email cannot be blank",Toast.LENGTH_LONG).show()
        }
    }
}