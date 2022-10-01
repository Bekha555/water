package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CalcInput : AppCompatActivity() {


    private lateinit var button: Button
    private lateinit var editText: EditText

    fun EditText.text() = toString().toInt()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc_input)

        button = findViewById(R.id.back_button)
        button.setOnClickListener {
            onBackPressed ()
        }

        button = findViewById(R.id.button17)
        editText = findViewById(R.id.editTextNumber3)











        val obshText: String by lazy {
            intent.extras?.get("text").toString()
        }

        val blagoText: String by lazy {
            intent.extras?.get("blagoText").toString()
        }
        val obshBlago = ("${obshText}  ${blagoText}")

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






button.setOnClickListener(View.OnClickListener {
    editText = findViewById(R.id.editTextNumber3)
    val message = editText.text.toString()
    if (message.trim().isNotEmpty()) {


        val intent = android.content.Intent(this, CalcInput2::class.java)
        intent.putExtra("Extra", message)
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

    else{
        Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()

        return@OnClickListener
    }
})


}

}
