package com.example.spkc6448.retrofit2.clients

import com.example.spkc6448.retrofit2.models.UnivListModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface UnivClientInterface {

    @GET("/webServices/getUnivAll.json")
    fun getUnivList(): Call<UnivListModel>

    @GET("/webServices/getUnivAll.json")
    fun getUnivListWithRxJava(): Single<UnivListModel>
}