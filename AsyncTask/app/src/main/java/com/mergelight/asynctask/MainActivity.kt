package com.mergelight.asynctask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculWithCoroutine()
        calculWithRx()
    }

    private fun calcul(): Int {
        var a = 0
        for(i in 1..1_000_000){
            a += 1
        }
        return a
    }

    private fun calculWithCoroutine(){
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val result = calcul()
                Log.d("Result calcul", "result with coroutine = ${result}")
            } catch (t: Throwable) {
                t.printStackTrace()
            }
        }
    }

    private fun calculWithRx(){
        val observable = Observable.create<Int> {
            it.onNext(calcul())
        }
        observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                val result = response
                Log.d("Result calcul", "result with rx = ${result}")
            }, { t ->
                t?.printStackTrace()
            })
    }
}