package com.example.beta1

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.beta1.utils.SessionManager
import kotlinx.android.synthetic.main.activity_save_data.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SaveData : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var adapterOf: rvAdapter
    private lateinit var sessionManager: SessionManager
    private lateinit var button: Button
    private lateinit var dialog: Dialog
    private lateinit var database: WaterDataBase

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data)

        val clearButton = findViewById<Button>(R.id.button21)
        database = Room.databaseBuilder(
            applicationContext, WaterDataBase::class.java, "Water"
        ).build()
        button = findViewById(R.id.back_button)
        //  sessionManager = SessionManager(this)


        database.waterDao().getAllData().observe(this) { dataList ->
            recycle.adapter = rvAdapter(dataList)
        }

        1
        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialog)
        dialog.getWindow()?.setBackgroundDrawable(getDrawable(R.drawable.background))
        dialog.getWindow()
            ?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.setCancelable(true)
        dialog.getWindow()?.getAttributes()?.windowAnimations = R.style.animation


        val okButton = dialog.findViewById<Button>(R.id.btn_yes)
        val noButton = dialog.findViewById<Button>(R.id.btn_no)

        okButton.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                delay(1500)
                database.waterDao().clearData()

            }
            Toast.makeText(this, "Очищено", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        noButton.setOnClickListener {
            dialog.dismiss()
        }


        clearButton.setOnClickListener {
            dialog.show()


//           val builder = AlertDialog.Builder(this)
//            builder.setTitle("Очистить все чеки?")
//            builder.setMessage("Вы больше не сможите восстановить их!")
//            builder.setNegativeButton("Нет") { dialog, i ->
//
//            }
//            builder.setPositiveButton("Да") { dialog, i ->
//                CoroutineScope(Dispatchers.IO).launch {
//
//                    database.waterDao().clearData()
//
//                }
//            }
//            builder.show()
        }


//        clearButton.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//
//                database.waterDao().clearData()
//
//            }
//        }


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