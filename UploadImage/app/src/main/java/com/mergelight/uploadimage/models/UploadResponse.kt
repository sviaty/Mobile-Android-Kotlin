package com.mergelight.uploadimage.models

data class UploadResponse (
    val error: Boolean,
    val message: String,
    val image: String
)