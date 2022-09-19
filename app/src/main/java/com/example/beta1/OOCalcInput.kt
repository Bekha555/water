package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class OOCalcInput : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var editText: EditText


    fun EditText.text() = toString().toInt()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oocalc_input)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            //   val intent = Intent (this, MainActivity::class.java)
            onBackPressed()
        }

        button = findViewById(R.id.Ok)
        editText = findViewById(R.id.editT)



        val obOO: String by lazy {
            intent.extras?.get("obOO").toString()
        }

        val obshText: String by lazy {
            intent.extras?.get("text").toString()
        }

        button.setOnClickListener (View.OnClickListener{
         editText = findViewById(R.id.editT)
            val OOmessage = editText.text.toString()
            if (OOmessage.trim().isNotEmpty()) {

                val intent = android.content.Intent(this, OOCalcInput2::class.java)
                intent.putExtra("OOExtra", OOmessage)
                val obshObOO = ("${obshText} -> ${obOO}")
                intent.putExtra("obshObOO", obshObOO)
                startActivity(intent)
            }
            else{

                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

                return@OnClickListener
            }
        })
    }
}