package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class FizTypeOfHouse : AppCompatActivity() {
    private lateinit var button: Button
    val fizText: String by lazy {
        intent.extras?.get("fizText").toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiz_type_of_house)
        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

    }

    //Хавли без счётчика
    val havBez: String = "Хавли без счётчика"
    fun startNewActivity9(view: View) {
        val intent = android.content.Intent(this, HavPeople::class.java)
        val fizHavBez = ("${fizText} -> ${havBez}")
        intent.putExtra("fizHavBez",fizHavBez)
        startActivity(intent)
    }
    //Многоэтажки 1-5 этаж без счетчика
    val mnogBez: String = "Многоэтажки 1-5 этаж без счетчика"
    fun startNewActivity10(view: View) {
        val intent = android.content.Intent(this, People::class.java)
        val fizmnogbez = ("${fizText} -> ${mnogBez}")
        intent.putExtra("fizmnogbez",fizmnogbez)
        startActivity(intent)
    }
    //Многоэтажки высше 5 эт.  без счетчика
    val mnogVishBez: String = "Многоэтажки высше 5 эт.  без счетчика"
    fun startNewActivity11(view: View) {
        val intent = android.content.Intent(this, People::class.java)
        val fizmnogVishBez = ("${fizText} -> ${mnogVishBez}")
        intent.putExtra("fizmnogVishBez",fizmnogVishBez)
        startActivity(intent)
    }
    //Хавли с счетчиком
    val havs: String = "Хавли с счетчиком"
    fun startNewActivity12(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val fizhavs = ("${fizText} -> ${havs}")
        intent.putExtra("fizhavs",fizhavs)
        startActivity(intent)
    }
    //Многоэтажки 1-5 этаж с счетчиком
    val mnogs: String = ("Многоэтажки 1-5 этаж с счетчиком")
    fun startNewActivity13(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val fizmnogs = ("${fizText} -> ${mnogs}")
        intent.putExtra("fizmnogs",fizmnogs)
        startActivity(intent)
    }
    //Многоэтажки высше 5 эт. с счетчиком
    val mnogVishs: String = "Многоэтажки высше 5 эт.  с счетчиком"
    fun startNewActivity14(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val fizmnogVishs = ("${fizText} -> ${mnogVishs}")
        intent.putExtra("fizmnogVishs",fizmnogVishs)
        startActivity(intent)
    }
}