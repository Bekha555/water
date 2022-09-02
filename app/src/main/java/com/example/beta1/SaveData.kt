package com.example.beta1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.beta1.utils.SessionManager


class SaveData : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var sessionManager: SessionManager
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data)
        button = findViewById(R.id.back_button)
        sessionManager = SessionManager(this)

        //set
        //sessionManager.paycheckNumber = ${sessionManager.paycheckNumber} + 5478

        //get
        //sessionManager.paycheckNumber
        textView = findViewById(R.id.textView9)
        textView.text = sessionManager.paycheckNumber


        button.setOnClickListener {
            onBackPressed()
        }





    }
}