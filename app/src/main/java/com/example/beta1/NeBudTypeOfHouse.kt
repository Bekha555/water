package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class NeBudTypeOfHouse : AppCompatActivity() {
    private lateinit var button: Button
    val gosNeBud: String by lazy {
        intent.extras?.get("gosNeBud").toString()
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ne_bud_type_of_house)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

    }

         //Хавли без счётчика
    val havBez: String = "Хавли без счётчика"
    fun startNewActivity20(view: View) {
        val intent = android.content.Intent(this, HavPeople::class.java)
        val gosNeBudHavBez = ("${gosNeBud}   ${havBez}")
        intent.putExtra("gosNeBudHavBez", gosNeBudHavBez)
        startActivity(intent)
    }

             //Многоэтажки 1-5 этаж без счетчика
    val mnogbez: String = "Многоэтажки 1-5 этаж без счетчика"
    fun startNewActivity21(view: View) {
        val intent = android.content.Intent(this, People::class.java)
        val gosNeBudmnogbez = ("${gosNeBud}   ${mnogbez}")
        intent.putExtra("gosNeBudmnogbez", gosNeBudmnogbez)
        startActivity(intent)
    }

                //Многоэтажки высше 5 эт.  без счетчика
      val mnogvishbez: String = "Многоэтажки высше 5 эт. без счетчика"
    fun startNewActivity22(view: View) {
        val gosNeBudmnogvishbez = ("${gosNeBud}   ${mnogvishbez}")
        val intent = android.content.Intent(this, People::class.java)
        intent.putExtra("gosNeBudmnogvishbez", gosNeBudmnogvishbez)
        startActivity(intent)
    }

                //Хавли с счётчиком
       val havs: String = "Хавли c счётчика"
    fun startNewActivity23(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val gosNeBudHavs = ("${gosNeBud}   ${havs}")
        intent.putExtra("gosNeBudHavs", gosNeBudHavs)
        startActivity(intent)
    }

                 //Многоэтажки 1-5 этаж с счетчиком
       val mnogs: String = "Многоэтажки 1-5 этаж с счетчиком"
    fun startNewActivity24(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val gosNeBudmnogs = ("${gosNeBud}   ${mnogs}")
        intent.putExtra("gosNeBudmnogs", gosNeBudmnogs)
        startActivity(intent)
    }

                //Многоэтажки высше 5 эт.  с счетчиком
    val mnogvishs: String = "Многоэтажки высше 5 эт.  с счетчиком"
    fun startNewActivity25(view: View) {
        val intent = android.content.Intent(this, CalcInput::class.java)
        val gosNeBudmnogvishs = ("${gosNeBud}   ${mnogvishs}")
        intent.putExtra("gosNeBudmnogvishs", gosNeBudmnogvishs)
        startActivity(intent)
    }
}


