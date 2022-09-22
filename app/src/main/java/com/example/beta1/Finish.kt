package com.example.beta1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.beta1.utils.SessionManager
import kotlinx.android.synthetic.main.activity_finish.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class Finish : AppCompatActivity() {


    private lateinit var sessionManager: SessionManager
    private lateinit var database: WaterDataBase

    val obshBlago: String by lazy {
        intent.extras?.get("obshBlago").toString()
    }
    val result: String by lazy {
        intent.extras?.get("result").toString()
    }

    val gosBud: String by lazy {
        intent.extras?.get("gosBud").toString()
    }
    val gosNeBudHavBez: String by lazy {
        intent.extras?.get("gosNeBudHavBez").toString()
    }
    val gosNeBudHavs: String by lazy {
        intent.extras?.get("gosNeBudHavs").toString()
    }
    val gosNeBudmnogs: String by lazy {
        intent.extras?.get("gosNeBudmnogs").toString()
    }
    val gosNeBudmnogbez: String by lazy {
        intent.extras?.get("gosNeBudmnogbez").toString()
    }
    val gosNeBudmnogvishs: String by lazy {
        intent.extras?.get("gosNeBudmnogvishs").toString()
    }
    val gosNeBudmnogvishbez: String by lazy {
        intent.extras?.get("gosNeBudmnogvishbez").toString()
    }
    val yurHavBez: String by lazy {
        intent.extras?.get("yurHavBez").toString()
    }
    val yourmnogbez: String by lazy {
        intent.extras?.get("yourmnogbez").toString()
    }

    val yurmnogVishBez: String by lazy {
        intent.extras?.get("yurmnogVishBez").toString()
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

    val fizHavBez: String by lazy {
        intent.extras?.get("fizHavBez").toString()
    }

    val fizmnogbez: String by lazy {
        intent.extras?.get("fizmnogbez").toString()
    }

    val fizmnogVishBez: String by lazy {
        intent.extras?.get("fizmnogVishBez").toString()
    }

    val fizmnogVishs: String by lazy {
        intent.extras?.get("fizmnogVishs").toString()
    }

    val fizhavs: String by lazy {
        intent.extras?.get("fizhavs").toString()
    }

    val fizmnogs: String by lazy {
        intent.extras?.get("fizmnogs").toString()
    }

    //Water value get
    val BudExtra: String by lazy {
        intent.extras?.get("BudExtra").toString()
    }
    val message: String by lazy {
        intent.extras?.get("Extra").toString()
    }
    val OOmessage: String by lazy {
        intent.extras?.get("OOExtra").toString()
    }


    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        database = Room.databaseBuilder(
            applicationContext, WaterDataBase::class.java, "Water"
        ).build()
        sessionManager = SessionManager(this)

        button = findViewById(R.id.back_button)


        button.setOnClickListener {
            //   val intent = Intent (this, MainActivity::class.java)
            onBackPressed()
        }

        button = findViewById(R.id.button17)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Получение Данных
        //Благотворительная организация
        val sum2 = intent.getStringExtra("Extra").toString()


        //Количество людей
        val sumpeop = intent.getStringExtra("ExtraP").toString()
        val havpeop = intent.getStringExtra("havExtra").toString()


        //Обычная ОО
        val OOmessageOne = intent.getStringExtra("OOExtraOne").toString()

        val obshObOO: String by lazy {
            intent.extras?.get("obshObOO").toString()
        }


        //Бьюджетная организация
        val budmessageOne = intent.getStringExtra("BudExtraOne").toString()


        //       val sharedPref = getSharedPreferences("key",Context.MODE_PRIVATE)


        val textView = findViewById<TextView>(R.id.textView9)
        val textView2 = findViewById<TextView>(R.id.textView2)

        //Вычисления Благотворительная орг
        if (intent.getStringExtra("Extra").toString() != "null") {
            textView.text = sum2.toString()
        }

        if (intent.getStringExtra("BudExtra").toString() != "null") {
            value.text = BudExtra.toString()
        }
        if (intent.getStringExtra("Extra").toString() != "null") {
            value.text = message.toString()
        }
        if (intent.getStringExtra("OOExtra").toString() != "null") {
            value.text = OOmessage.toString()
        }




        button = findViewById(R.id.button19)
        button.setOnClickListener() {
            //sessionManager.paycheckNumber = textView.text.toString()
            // Log.e("TAG", "PAYCHECK:" + sessionManager.paycheckNumber)
            //DataObject.(id, create_title.text.toString())
            val value = value.text.toString() + " " + "m³" + "воды"
            val title = textView9.text.toString() + "смн" + " "
            val date = SimpleDateFormat(
                "dd.MM.yyyy HH:mm:ss",
                Locale.getDefault()
            ).format(Date())
            val sections = textView2.text.toString()
            DataObject.setData(title = title, date = date, sections = sections, value = value)

            CoroutineScope(Dispatchers.IO).launch {
                database.waterDao().insertTask(
                    Water(title = title, date = date, sections = sections, water = value)

                )
            }

            Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
        }

        // Get Water Value


        //Вывод Обычное ОО
        if (intent.getStringExtra("OOExtraOne").toString() != "null") {
            textView.text = OOmessageOne.toString()
        }

        if (intent.getStringExtra("BudExtraOne").toString() != "null") {
            textView.text = budmessageOne.toString()
        }

        //Многоэтажки без счётчика
        if (intent.getStringExtra("ExtraP").toString() != "null") {
            textView.text = sumpeop.toString()
        }
        // Хавли без счётчика

        if (intent.getStringExtra("havExtra").toString() != "null") {
            textView.text = havpeop.toString()
        }



        if (intent.extras?.get("obshBlago").toString() != "null") {
            textView2.text = obshBlago.toString()
        }

        if (intent.extras?.get("obshObOO").toString() != "null") {
            textView2.text = obshObOO
        }

        if (intent.extras?.get("gosBud").toString() != "null") {
            textView2.text = gosBud
        }

        if (intent.extras?.get("gosNeBudHavBez").toString() != "null") {
            textView2.text = gosNeBudHavBez
        }

        if (intent.extras?.get("gosNeBudHavs").toString() != "null") {
            textView2.text = gosNeBudHavs
        }

        if (intent.extras?.get("gosNeBudmnogs").toString() != "null") {
            textView2.text = gosNeBudmnogs
        }

        if (intent.extras?.get("gosNeBudmnogbez").toString() != "null") {
            textView2.text = gosNeBudmnogbez
        }

        if (intent.extras?.get("gosNeBudmnogvishs").toString() != "null") {
            textView2.text = gosNeBudmnogvishs
        }

        if (intent.extras?.get("gosNeBudmnogvishbez").toString() != "null") {
            textView2.text = gosNeBudmnogvishbez
        }

        if (intent.extras?.get("yurHavBez").toString() != "null") {
            textView2.text = yurHavBez
        }

        if (intent.extras?.get("yourmnogbez").toString() != "null") {
            textView2.text = yourmnogbez
        }

        if (intent.extras?.get("yurmnogVishBez").toString() != "null") {
            textView2.text = yurmnogVishBez
        }

        if (intent.extras?.get("yurhavs").toString() != "null") {
            textView2.text = yurhavs
        }

        if (intent.extras?.get("yurmnogs").toString() != "null") {
            textView2.text = yurmnogs
        }

        if (intent.extras?.get("yurmnogVishs").toString() != "null") {
            textView2.text = yurmnogVishs
        }

        if (intent.extras?.get("fizHavBez").toString() != "null") {
            textView2.text = fizHavBez
        }

        if (intent.extras?.get("fizmnogbez").toString() != "null") {
            textView2.text = fizmnogbez
        }

        if (intent.extras?.get("fizmnogVishBez").toString() != "null") {
            textView2.text = fizmnogVishBez
        }

        if (intent.extras?.get("fizhavs").toString() != "null") {
            textView2.text = fizhavs
        }

        if (intent.extras?.get("fizmnogs").toString() != "null") {
            textView2.text = fizmnogs
        }

        if (intent.extras?.get("fizmnogVishs").toString() != "null") {
            textView2.text = fizmnogVishs
        }


        /*val name = sharedPref.getString("name","default value").toString()
        Toast.makeText(this, name, Toast.LENGTH_SHORT).show()
        textView.text = (name).toString()*/

    }
}

