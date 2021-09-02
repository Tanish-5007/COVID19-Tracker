package com.example.covid19_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covid19_tracker.databinding.ActivityMainBinding
import com.google.gson.Gson
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchResult()

    }

    @DelicateCoroutinesApi
    private fun fetchResult() {
        GlobalScope.launch(Dispatchers.IO) {
            val response = withContext(Dispatchers.IO){ Client.api.execute() }
            if(response.isSuccessful){
                val data = response.body?.string()
                val result = Gson().fromJson(data, Response::class.java)
            }
        }

    }
}