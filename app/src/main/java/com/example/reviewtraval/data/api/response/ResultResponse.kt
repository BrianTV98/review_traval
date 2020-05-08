package com.example.reviewtraval.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultResponse(
    @SerializedName("created")
    @Expose
    val created : Boolean
)