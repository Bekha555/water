package com.example.beta1

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi

class People : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText
    fun EditText.text() = toString()

    val gosNeBudmnogbez : String by lazy {
        intent.extras?.get("gosNeBudmnogbez").toString()
    }

    val gosNeBudmnogvishbez : String by lazy {
        intent.extras?.get("gosNeBudmnogvishbez").toString()
    }

    val yourmnogbez : String by lazy {
        intent.extras?.get("yourmnogbez").toString()
    }

    val yurmnogVishBez : String by lazy {
        intent.extras?.get("yurmnogVishBez").toString()
    }

    val fizmnogbez : String by lazy {
        intent.extras?.get("fizmnogbez").toString()
    }

    val fizmnogVishBez : String by lazy {
        intent.extras?.get("fizmnogVishBez").toString()
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people)
        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

       button = findViewById(R.id.button15)
        button.setOnClickListener() {


            editText = findViewById(R.id.editText1)
            val peopNumber = editText.text.toString()
            val sumpeop = ((peopNumber).toInt() *  8.41).toString()
            val intent = android.content.Intent(this, Finish::class.java)
            intent.putExtra("ExtraP", sumpeop)
            intent.putExtra("gosNeBudmnogbez", gosNeBudmnogbez)
            intent.putExtra("gosNeBudmnogvishbez", gosNeBudmnogvishbez)
            intent.putExtra("yourmnogbez",yourmnogbez)
            intent.putExtra("yurmnogVishBez",yurmnogVishBez)
            intent.putExtra("fizmnogbez",fizmnogbez)
            intent.putExtra("fizmnogVishBez",fizmnogVishBez)
            startActivity(intent)

        }
    }
}
