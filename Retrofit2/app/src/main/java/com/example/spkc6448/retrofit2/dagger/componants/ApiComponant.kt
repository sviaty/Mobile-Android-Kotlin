package com.example.spkc6448.retrofit2.dagger.componants

import com.example.spkc6448.retrofit2.activities.RetrofitActivity
import com.example.spkc6448.retrofit2.activities.RetrofitWithDaggerActivity
import com.example.spkc6448.retrofit2.activities.RetrofitWithRxJavaActivity
import com.example.spkc6448.retrofit2.dagger.modules.ApiRetrofitModule
import dagger.Component
import javax.inject.Singleton



@Singleton
@Component(modules = arrayOf(ApiRetrofitModule::class))
interface ApiComponant {
    fun inject(retrofitActivity: RetrofitActivity)
    fun inject(retrofitWithDagger: RetrofitWithDaggerActivity)
    fun inject(retrofitWithRxJava: RetrofitWithRxJavaActivity)
}