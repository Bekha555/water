package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button20)
        button.setOnClickListener(){
            val intent = android.content.Intent(this, SaveData::class.java)
            startActivity(intent)
        }






    }
    //Общественная организация
    public fun startNewActivity(view: View) {
        val obshText: String = "Общественная организация"
    val intent = Intent(this, TypeOfUser::class.java)
        intent.putExtra("text", obshText).toString()
        startActivity(intent)
    }
   //Государственная организация
    public fun startNewActivity2(view: View) {
       val gosText = ("Государственная организация")
        val intent = Intent (this, TypeOfUser2::class.java)
       intent.putExtra("gosText", gosText)
        startActivity(intent)
    }
    //Юридическое Лицо
    public fun startNewActivity3(view: View) {
        val yurText = ("Юридическое Лицо")
        val intent = Intent (this, TypeOfHouse::class.java)
        intent.putExtra("yurText", yurText)
        startActivity(intent)
    }
    //Физическое лицо
    public fun startNewActivity4(view: View) {
        val fizText = ("Физическое лицо")
        val intent = Intent (this, FizTypeOfHouse::class.java)
        intent.putExtra("fizText", fizText)
        startActivity(intent)
    }


}