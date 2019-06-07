package com.example.spkc6448.retrofit2.retrofit

import com.example.spkc6448.retrofit2.clients.UnivClientInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider(url: String = "") {

    lateinit var univClientInterface: UnivClientInterface
    var mUrl: String = ""

    init {
        mUrl = url
        createWebInterface()
    }

    fun createWebInterface() {

//        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor { chain ->
//            val original = chain.request()
//            val requestBuilder = original.newBuilder()
//                .header("Authorization", "X-Sah-Login")
//                .header("Content-Type", "application/x-sah-ws-4-call+json")
//            val request = requestBuilder.build()
//            chain.proceed(request)
//        }
//
//        val client = httpClient.build()

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
        val retrofit = Retrofit.Builder()
//            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(mUrl)
            .build()
        univClientInterface = retrofit.create(UnivClientInterface::class.java)
    }
}