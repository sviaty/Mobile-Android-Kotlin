package com.mergelight.sqlite.models

data class Contact(
    var mIdContact: Int? = 0,
    var mNameContact: String,
    var mTelContact: String
) {
    constructor(): this(
        0,
        "",
        ""
    )
}