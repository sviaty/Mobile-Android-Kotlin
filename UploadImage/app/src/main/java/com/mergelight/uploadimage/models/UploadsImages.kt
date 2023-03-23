package com.mergelight.uploadimage.models

import com.google.gson.annotations.SerializedName

data class UploadsImages (
    @SerializedName("idUpload")
    val idUpload: Int,
    @SerializedName("imgUrl")
    val imgUrl: String,
    @SerializedName("imgDesc")
    val imgDesc: String
)
