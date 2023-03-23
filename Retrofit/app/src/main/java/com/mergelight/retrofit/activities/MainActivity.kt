package com.mergelight.retrofit.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mergelight.retrofit.api.retrofit.ApiRetrofitClient
import com.mergelight.retrofit.R
import com.mergelight.retrofit.models.User
import com.mergelight.retrofit.models.UserResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var mTvUserName: TextView
    private var mUser: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

        //getUserWithCallRetrofit()
        //getUserWithCoroutines()
        getUserWithRx()
    }

    private fun setupView(){
        mTvUserName = findViewById(R.id.tv_user_name)
    }

    private fun getUserWithCallRetrofit(){
        var retrofit = ApiRetrofitClient.apiService
        val responseGetUsers = retrofit.getUserById2(60)
        responseGetUsers.enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val responseBody = response.body()
                mUser = responseBody?.mData
                //mTvUserName.text = mUser?.mName
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }

    private fun getUserWithCoroutines() {
        var retrofit = ApiRetrofitClient.apiService
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val responseGetUsers = retrofit.getUserById(60)
                if (responseGetUsers.isSuccessful && responseGetUsers.body() != null) {
                    val responseBody = responseGetUsers.body()
                    mUser = responseBody?.mData
                    //mTvUserName.text = mUser?.mName
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Error Occurred: ${responseGetUsers.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (t: Throwable) {
                t?.printStackTrace()
            }
        }
    }

    private fun getUserWithRx() {
        var retrofit = ApiRetrofitClient.apiService
        val responseGetUsers2: Observable<UserResponse> = retrofit.getUserById3(60)
        responseGetUsers2.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                mUser = response.mData
                mTvUserName.text = mUser?.mName
            }, { t ->
                t?.printStackTrace()
            })
    }

}