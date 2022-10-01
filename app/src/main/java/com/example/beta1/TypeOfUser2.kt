package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class TypeOfUser2 : AppCompatActivity() {
    private lateinit var button: Button

    val gosText: String by lazy {
        intent.extras?.get("gosText").toString()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_of_user2)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }


    }

    //Бьюджетная организация
    val budText: String = "Бьюджетная Организация"
    fun startNewActivity7(view: View) {
        val intent = android.content.Intent(this, BudCalcInput::class.java)
        val gosBud = ("${gosText}   ${budText}")
        intent.putExtra("gosBud",gosBud)
        startActivity(intent)
    }

//-------------------------------------------------------------------------------------------------------------------------------------


    //Не Бьюджетная организация
    val nebud: String = "Не Бьюджетная Организация"
    fun startNewActivity8(view: View) {
        val intent = android.content.Intent(this, NeBudTypeOfHouse::class.java)
        val gosNeBud = ("${gosText}   ${nebud}")
        intent.putExtra("gosNeBud",gosNeBud)
        startActivity(intent)

    }
}