package com.mergelight.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.ExecutorService


class MyService() : Service() {

    override fun onCreate() {
        super.onCreate()
        Log.i("Service", "Service onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("Service", "Service onStartCommand")

        test()
        return START_STICKY
        //return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        Log.i("Service", "Service onBind")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Service", "Service onDestroy")
    }

    private fun test(){
        GlobalScope.launch(Dispatchers.IO) {
            try {
                Log.i("Service", "Début de l'exécution")
                delay(5_000)
                Log.i("Service", "Fin de l'exécution")
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }
}