package com.mergelight.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = Intent(this, MyService::class.java)
        startService(service)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                delay(10_000)
                stopService(service)
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}