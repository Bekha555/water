package com.example.beta1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity




class TypeOfUser : AppCompatActivity() {
    private lateinit var button: Button

    val obshText : String by lazy {
        intent.extras?.get("text").toString()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_of_user)



        button = findViewById(R.id.button16)
        button.setOnClickListener {
         //   val intent = Intent (this, MainActivity::class.java)
            onBackPressed ()
        }




    }
                    //Благотворительная организация
   // val obshText = intent.getStringExtra("text").toString()
    val blagoText: String = "Благотворительная организация"

    fun startNewActivity5(view:View) {
        val intent = Intent (this, CalcInput::class.java)
        intent.putExtra("text", obshText)
         intent.putExtra("blagoText", blagoText)
        startActivity(intent)
    }

                    //Обычная ОО
    val obOO: String = "Обычная ОО"

    fun startNewActivity6(view:View) {
        val intent = Intent (this, OOCalcInput::class.java)
        intent.putExtra("text", obshText)
        intent.putExtra("obOO", obOO)
        startActivity(intent)
    }
}
