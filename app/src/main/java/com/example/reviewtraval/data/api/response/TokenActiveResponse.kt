package com.example.reviewtraval.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TokenActiveResponse(

    @SerializedName("exist")
    @Expose
    val exist: Boolean,

    @SerializedName("is_activated")
    @Expose
    val is_activated: Boolean
)