package com.example.reviewtraval.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("created")
    @Expose
    val created: Boolean,

    @SerializedName("modified")
    @Expose
    val modified: Boolean
)