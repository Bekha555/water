package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class CalcInput2 : AppCompatActivity() {

    val obshBlago: String by lazy {
        intent.extras?.get("obshBlago").toString()
    }
    val gosNeBudHavs: String by lazy {
        intent.extras?.get("gosNeBudHavs").toString()
    }
    val gosNeBudmnogs: String by lazy {
        intent.extras?.get("gosNeBudmnogs").toString()
    }
    val gosNeBudmnogvishs: String by lazy {
        intent.extras?.get("gosNeBudmnogvishs").toString()
    }
    val yurhavs: String by lazy {
        intent.extras?.get("yurhavs").toString()
    }
    val yurmnogs: String by lazy {
        intent.extras?.get("yurmnogs").toString()
    }
    val yurmnogVishs: String by lazy {
        intent.extras?.get("yurmnogVishs").toString()
    }
    val fizhavs: String by lazy {
        intent.extras?.get("fizhavs").toString()
    }
    val fizmnogs: String by lazy {
        intent.extras?.get("fizmnogs").toString()
    }
    val fizmnogVishs: String by lazy {
        intent.extras?.get("fizmnogVishs").toString()
    }


    fun startNewActivityback(view: View) {
        onBackPressed()
    }

    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toInt()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_input2)
        button = findViewById(R.id.button18)
        button.setOnClickListener {


            val message = intent.getStringExtra("Extra").toString()

            //   Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            editText = findViewById(R.id.editTextNumber3)

            val messageOne = editText.text.toString()
            if (messageOne.trim().isNotEmpty()) {


                val sum = message.toInt() - messageOne.toInt()

            val sum2 = (sum * 2.34).toString()

            if (sum < 0) {
                Toast.makeText(this, "Эти показатели должны быть меньше", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }


            val intent = android.content.Intent(this, Finish::class.java)
            intent.putExtra("Extra", sum2)
            intent.putExtra("obshBlago", obshBlago)
            intent.putExtra("gosNeBudHavs", gosNeBudHavs)
            intent.putExtra("gosNeBudmnogs", gosNeBudmnogs)
            intent.putExtra("gosNeBudmnogvishs", gosNeBudmnogvishs)
            intent.putExtra("yurhavs", yurhavs)
            intent.putExtra("yurmnogs", yurmnogs)
            intent.putExtra("yurmnogVishs", yurmnogVishs)
            intent.putExtra("fizhavs", fizhavs)
            intent.putExtra("fizmnogs", fizmnogs)
            intent.putExtra("fizmnogVishs", fizmnogVishs)

            startActivity(intent)
            }
            else {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

                return@setOnClickListener
            }
        }
    }

}



