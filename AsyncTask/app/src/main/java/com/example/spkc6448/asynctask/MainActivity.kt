package com.example.spkc6448.asynctask

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calc = CalculAsyncTask()
        calc.execute()

        Observable.create<Int> { emitter ->
            emitter.onNext(calcul())
            emitter.onComplete()
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                result ->
                Log.d("calculObservable", "result = $result")
            },{
                error ->
                Log.e("calculObservable", "error = ${error.message}")
            })
    }

    fun calcul(): Int {
        var a = 0
        for(i in 0..1000000){
            a += 1
        }
        return a
    }
}
