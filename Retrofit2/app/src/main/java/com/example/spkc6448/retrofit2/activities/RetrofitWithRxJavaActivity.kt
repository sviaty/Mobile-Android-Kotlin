package com.example.spkc6448.retrofit2.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.spkc6448.retrofit2.R
import com.example.spkc6448.retrofit2.clients.UnivClientInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RetrofitWithRxJavaActivity: AppCompatActivity() {

    @Inject
    var mUnivClientInterface: UnivClientInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getUnivListWithRxJava()
    }

    private fun getUnivListWithRxJava() {
        mUnivClientInterface!!.getUnivListWithRxJava()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {   result ->
                    val univListSize = result?.mUnivList?.size
                    Log.d("univListWithRxJava : ", "nombre d univ = $univListSize")

                },
                {   error ->
                    Log.e("univListError : ", "retrofit error : $error")
                }
            )
    }
}