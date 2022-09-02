package com.example.beta1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beta1.databinding.ActivityMainBinding
import com.example.beta1.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class splashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
    CoroutineScope(Dispatchers.Main).launch {
        delay(1500)
        finish()
        startActivity(Intent(this@splashActivity, MainActivity::class.java) )
    }
    }
}