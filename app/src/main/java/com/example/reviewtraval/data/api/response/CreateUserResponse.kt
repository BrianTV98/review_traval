package com.example.reviewtraval.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CreateUserResponse(
    @SerializedName("activate")
    @Expose
    val activate : String,

    @SerializedName("exist")
    @Expose
    val exist : String,

    @SerializedName("created")
    @Expose
    val created : String
)