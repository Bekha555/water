package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OOCalcInput2 : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toInt()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oocalc_input2)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            //   val intent = Intent (this, MainActivity::class.java)
            onBackPressed()
        }

        button = findViewById(R.id.ok2)
        button.setOnClickListener {
            val obshObOO: String by lazy {
                intent.extras?.get("obshObOO").toString()
            }


            val OOmessage = intent.getStringExtra("OOExtra").toString()
            val OOliter = OOmessage + "" + "m³"

            editText = findViewById(R.id.ooeditT)
            val OOmessageOne = editText.text.toString()
            if (OOmessageOne.trim().isNotEmpty()) {

            val sum = OOmessage.toInt() - OOmessageOne.toInt()
            val sum2 = (sum * 6.70).toString()
            if (sum < 0) {
                Toast.makeText(this, "Эти показатели должны быть меньше", Toast.LENGTH_SHORT).show()



                return@setOnClickListener
            }


                val intent = android.content.Intent(this, Finish::class.java)
                intent.putExtra("OOExtraOne", sum2)
                intent.putExtra("obshObOO", obshObOO)

                intent.putExtra("OOliter", OOliter)

                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }

        }
    }
}