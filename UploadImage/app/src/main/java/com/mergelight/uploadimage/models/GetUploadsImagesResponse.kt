package com.mergelight.uploadimage.models

import com.google.gson.annotations.SerializedName

class GetUploadsImagesResponse(
    @SerializedName("status")
    val mStatus: String?,

    @SerializedName("data")
    val mData: Array<UploadsImages>
)
