package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class TypeOfHouse : AppCompatActivity() {
private lateinit var button: Button
    val yurText: String by lazy {
        intent.extras?.get("yurText").toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_of_house)
        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }



    }

        //Хавли без счётчика
        val havBez: String = "Хавли без счётчика"
        fun startNewActivity9(view: View) {
            val intent = android.content.Intent(this, HavPeople::class.java)
            val yurHavBez = ("${yurText} -> ${havBez}")
            intent.putExtra("yurHavBez",yurHavBez)
            startActivity(intent)
        }
         //Многоэтажки 1-5 этаж без счетчика
    val mnogBez: String = "Многоэтажки 1-5 этаж без счетчика"
        fun startNewActivity10(view: View) {
            val intent = android.content.Intent(this, People::class.java)
            val yourmnogbez = ("${yurText} -> ${mnogBez}")
            intent.putExtra("yourmnogbez",yourmnogbez)
            startActivity(intent)
        }
        //Многоэтажки высше 5 эт.  без счетчика
    val mnogVishBez: String = "Многоэтажки высше 5 эт.  без счетчика"
        fun startNewActivity11(view: View) {
            val intent = android.content.Intent(this, People::class.java)
            val yurmnogVishBez = ("${yurText} -> ${mnogVishBez}")
            intent.putExtra("yurmnogVishBez",yurmnogVishBez)
            startActivity(intent)
        }
        //Хавли с счетчиком
    val havs: String = "Хавли с счетчиком"
        fun startNewActivity12(view: View) {
            val intent = android.content.Intent(this, CalcInput::class.java)
            val yurhavs = ("${yurText} -> ${havs}")
            intent.putExtra("yurhavs",yurhavs)
            startActivity(intent)
        }
        //Многоэтажки 1-5 этаж с счетчиком
    val mnogs: String = ("Многоэтажки 1-5 этаж с счетчиком")
        fun startNewActivity13(view: View) {
            val intent = android.content.Intent(this, CalcInput::class.java)
            val yurmnogs = ("${yurText} -> ${mnogs}")
            intent.putExtra("yurmnogs",yurmnogs)
            startActivity(intent)
        }
        //Многоэтажки высше 5 эт. с счетчиком
    val mnogVishs: String = "Многоэтажки высше 5 эт.  с счетчиком"
        fun startNewActivity14(view: View) {
            val intent = android.content.Intent(this, CalcInput::class.java)
            val yurmnogVishs = ("${yurText} -> ${mnogVishs}")
            intent.putExtra("yurmnogVishs",yurmnogVishs)
            startActivity(intent)
        }

}

