package com.example.reviewtraval.data.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @SerializedName("api_token")
    @Expose
    val api_token : String,

    @SerializedName("error")
    @Expose
    val error : String,


    @SerializedName("required")
    @Expose
    val required : String

)