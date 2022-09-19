package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class BudCalcInput2 : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toDouble()

    val gosBud: String by lazy {
        intent.extras?.get("gosBud").toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bud_calc_input2)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

        button = findViewById(R.id.budok2)
        button.setOnClickListener {


            val budmessage = intent.getStringExtra("BudExtra").toString()

            editText = findViewById(R.id.budeditT)
            val budmessageOne = editText.text.toString()
            if (budmessageOne.trim().isNotEmpty()) {


            val sum = budmessage.toInt() - budmessageOne.toInt()
            val sum2 = (sum * 2.66).toString()
            if (sum < 0) {
                Toast.makeText(this, "Эти показатели должны быть меньше", Toast.LENGTH_SHORT).show()



                return@setOnClickListener
            }


            val intent = android.content.Intent(this, Finish::class.java)
            intent.putExtra("BudExtraOne", sum2)
            intent.putExtra("gosBud",gosBud)

            startActivity(intent)
            }
            else{
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
        }
    }
}