package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BudCalcInput : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toInt()

    val gosBud: String by lazy {
        intent.extras?.get("gosBud").toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bud_calc_input)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

        button = findViewById(R.id.budOk)
        editText = findViewById(R.id.budeditT)

        button.setOnClickListener {
            callActivity()
        }
    }
    private fun callActivity() {
        editText = findViewById(R.id.budeditT)
        val Budmessage = editText.text.toString()

        val intent = android.content.Intent(this, BudCalcInput2::class.java)
        intent.putExtra("BudExtra", Budmessage)
        intent.putExtra("gosBud",gosBud)

        startActivity(intent)



    }
}