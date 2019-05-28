package com.example.spkc6448.rxandroid

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.tbruyelle.rxpermissions2.RxPermissions
import java.util.*
import java.util.concurrent.TimeUnit
import io.reactivex.functions.BiFunction


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chaineConcat = rxExampleCreate()
        val chaineToUpperCase = rxExampleMap()
        val chaineWithSpace = rxExampleFlatmap()
        val pairNumber = rxExampleGroupby()
        val imparNumber = rxExampleFilter()
        val chaineIsEmpty = rxExampleDefaultIfEmpty()

        rxExampleDelay()
        rxExampleTimer()
        rxExampleInterval()
        rxExampleIntervalTake()
        rxExampleDoOnNext()
        rxExampleAndroidSchedulers()
        rxExampleZip()

        rxExamplePermission()
    }

    private fun rxExampleCreate():String {
        var result = ""
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        // Création de l'oberservable
        // Dans un observable on a les 3 écouteurs onNext(), onComplete() et onError()
        val observable = Observable.just(letters)
        // Traitement de l'observable
        observable
            .subscribe ({
                    letter -> result += letter // onNext()
            },{
                    error -> Log.e("errror", error.message) // onError()
            })
        return result
    }

    private fun rxExampleMap():String {

        var result = ""
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        val observable = Observable.just(letters)

        observable
            .map { letters: List<String> ->
                for (letter in letters) {
                    result += letter.toUpperCase()
                }
            }
            .subscribe { it -> result
                result += result + "_completed"
            }
        return result
    }

    private fun rxExampleFlatmap(): String {
        val items = listOf("a", "b", "c", "d", "e", "f")
        var result = ""

        Observable.fromIterable(items)
            .flatMap { s -> Observable.fromArray(s.split(" ")) }
            .doOnNext { System.out.println()}
            .subscribe { it -> result = it.toString() }

        return result
    }

    private fun rxExampleGroupby(): ArrayList<String> {

        val numbers = "0123456789"
        val pair = arrayListOf<String>()
        val observable = Observable.fromArray(numbers)

        observable
            .groupBy { i ->
                if (0 == i.toInt() % 2) "EVEN" else "ODD"
            }
            .subscribe { group ->
                group.subscribe { number ->
                    if (group.getKey().toString().equals("EVEN")) {
                        pair.add(number)
                    }
                }
            }
        return pair
    }

    private fun rxExampleFilter(): ArrayList<String>  {

        val numbers = "0123456789"
        val impair = arrayListOf<String>()
        val observable = Observable.fromArray(numbers)

        observable
            .filter { i -> i.toInt() % 2 == 1 }
            .subscribe { i -> impair.add(i) }
        return impair
    }

    private fun rxExampleDelay() {
        Observable.create<String> { emitter ->
            Log.d("DelayExample", "Create")
            emitter.onNext("MindOrks")
            emitter.onComplete()
        }
            .subscribeOn(Schedulers.io())
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("DelayExample", it)
            }
    }

    private fun rxExampleDefaultIfEmpty():String {
        var numbers = ""
        val observable = Observable.fromArray(numbers)

        observable
            .defaultIfEmpty("Observable is empty")
            .subscribe { it -> numbers += it }
        return numbers
    }

    private fun rxExampleDoOnNext() {
//        val observable = Observable
        Observable.range(1, 3)
            .doOnNext { value ->
                println("before transform: $value") }
            .map { value -> value * 2 }
            .doOnNext { value ->
                println("after transform: $value") }
            .subscribe()
    }

    private fun rxExampleTimer() {
        Observable.timer(2, TimeUnit.SECONDS)
            .flatMap {
                return@flatMap Observable.create<String> { emitter ->
                    Log.d("TimerExample", "Create")
                    emitter.onNext("MindOrks")
                    emitter.onComplete()
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("TimerExample", it)
            }
    }

    private fun rxExampleInterval() {
        Observable
            .interval(5, 2, TimeUnit.SECONDS)
            .subscribe { l -> println(Thread.currentThread().name + ": A " + l) }

        Observable
            .interval(5, 2, TimeUnit.SECONDS)
            .subscribe { l -> println(Thread.currentThread().name + ": B " + l) }
    }

    private fun rxExampleIntervalTake() {
        Observable.interval(0, 2, TimeUnit.SECONDS)
            .take(5)
            .flatMap {
                return@flatMap Observable.create<String> { emitter ->
                    Log.d("IntervalExample", "Create")
                    emitter.onNext("MindOrks")
                    emitter.onComplete()
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("IntervalExample", it)
            }
    }

    private fun rxExampleAndroidSchedulers() {
        val letters = listOf("a", "b", "c", "d", "e", "f", "g")
        val observable = Observable.just(letters)
        observable
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data ->
                Log.d("dataOk",data.toString())
            },{
                error ->
                print(error.message)
            })
    }

    private fun rxExampleZip() {
        val obs1 = Observable.fromArray(1, 3, 5, 7, 9)
        val obs2 = Observable.fromArray(2, 4, 6)

        Observable
            .zip(
                obs1,
                obs2,
                BiFunction<Int, Int, List<Int>> {
                        value1, value2 ->
                        val list = ArrayList<Int>()
                        list.add(value1)
                        list.add(value2)
                    return@BiFunction list
                })
            .subscribe(

            )
    }

    private fun rxExamplePermission() {
        RxPermissions.getInstance(this)
            .request(Manifest.permission.CAMERA)
            .subscribe { granted ->
                if (granted) { // Always true pre-M
                    // I can control the camera now
                } else {
                    // Oups permission denied
                }
            }
    }
}
