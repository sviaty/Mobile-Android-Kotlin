package com.mergelight.retrofit.api.retrofit

import com.mergelight.retrofit.models.User
import com.mergelight.retrofit.models.UserResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRetrofitService {
    @GET("members/{num}")
    suspend fun getUserById(@Path("num") num : Int): Response<UserResponse>

    @GET("members/{num}")
    fun getUserById2(@Path("num") num : Int): Call<UserResponse>

    @GET("members/{num}")
    fun getUserById3(@Path("num") num : Int): Observable<UserResponse>
}