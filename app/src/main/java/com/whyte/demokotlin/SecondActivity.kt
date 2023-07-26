package com.whyte.demokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.whyte.demokotlin.databinding.ActivitySecondBinding
import kotlinx.coroutines.*

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.tx1.text = "Hello this is karan here"

        binding.tx1.setOnClickListener {
            startActivity(Intent(this@SecondActivity, MainActivity::class.java))
        }

        CoroutineScope(Dispatchers.Default).launch {

        }

        CoroutineScope(Dispatchers.Main).launch {

        }

        CoroutineScope(Dispatchers.IO).launch {

        }

    }

}