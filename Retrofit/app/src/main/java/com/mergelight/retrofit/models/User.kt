package com.mergelight.retrofit.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("idMember")
    val mId: Int? = null,
    @SerializedName("lastName")
    val mName: String? = null,
    @SerializedName("eMail")
    val mMail: String? = null
)
