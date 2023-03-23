package com.mergelight.uploadimage.retrofit

import com.mergelight.uploadimage.models.GetUploadsImagesResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import com.mergelight.uploadimage.models.UploadResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiRetrofitService {

    @Multipart
    @POST("upload")
    fun uploadImage(
        @Part image: MultipartBody.Part,
        @Part("desc") desc : RequestBody
    ): Call<UploadResponse>

    @Multipart
    @POST("upload")
    fun uploadImage2(
        @Part image: MultipartBody.Part,
        @Part("desc") desc : RequestBody
    ): Response<UploadResponse>

    @GET("upload")
    fun getUploadsImages(): Call<GetUploadsImagesResponse>
}