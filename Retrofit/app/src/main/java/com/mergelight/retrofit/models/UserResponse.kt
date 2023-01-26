package com.mergelight.retrofit.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("status")
    val mStatus: String?,

    @SerializedName("data")
    val mData: User
)
