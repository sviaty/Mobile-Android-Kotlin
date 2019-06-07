package com.example.spkc6448.retrofit2.dagger.modules

import com.example.spkc6448.retrofit2.clients.UnivClientInterface
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiRetrofitModule {

    @Singleton
    @Provides
    fun provideApiRetrofitService(url: String = ""): UnivClientInterface {

        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(url)
            .build()
        return retrofit.create(UnivClientInterface::class.java)
    }
}