package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class HavPeople : AppCompatActivity() {
    val gosNeBudHavBez: String by lazy {
        intent.extras?.get("gosNeBudHavBez").toString()
    }

    val yurHavBez: String by lazy {
        intent.extras?.get("yurHavBez").toString()
    }

    val fizHavBez: String by lazy {
        intent.extras?.get("fizHavBez").toString()
    }

    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toDouble()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hav_people)
        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }


        button = findViewById(R.id.havButton)
        editText = findViewById(R.id.havEditText)

        button.setOnClickListener {

            editText = findViewById(R.id.havEditText)
            val havNumber = editText.text.toString()
            val count = havNumber + "" + "чел..."
            if (havNumber.trim().isNotEmpty()) {
                val havpeop = ((havNumber).toInt() * 4.94).toString()
                val intent = android.content.Intent(this, Finish::class.java)
                intent.putExtra("havExtra", havpeop)
                intent.putExtra("gosNeBudHavBez", gosNeBudHavBez)
                intent.putExtra("yurHavBez", yurHavBez)
                intent.putExtra("fizHavBez", fizHavBez)
                intent.putExtra("count", count)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

                return@setOnClickListener

            }
        }
        }
    }
