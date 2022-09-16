package com.example.beta1

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.room.Room
import com.example.beta1.utils.SessionManager
import kotlinx.android.synthetic.main.activity_save_data.*


class SaveData : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var adapterOf: rvAdapter
    private lateinit var sessionManager: SessionManager
    private lateinit var button: Button

    private lateinit var database: WaterDataBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data)
        database = Room.databaseBuilder(
            applicationContext, WaterDataBase::class.java, "water"
        ).build()
        button = findViewById(R.id.back_button)
        sessionManager = SessionManager(this)


        recycle.adapter = rvAdapter(DataObject.getAllData())
        //sessionManager = SessionManager(this)


        //set
        //sessionManager.paycheckNumber = ${sessionManager.paycheckNumber} + 5478

        //get
        //sessionManager.paycheckNumber
            //textView = findViewById(R.id.textView9)
        //textView.text = sessionManager.paycheckNumber


        button.setOnClickListener {
            onBackPressed()
        }





    }
}