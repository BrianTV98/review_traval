package com.example.reviewtraval.data.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AccountModel(

    @SerializedName("username")
    @Expose
    val username: String,

    @SerializedName("password")
    @Expose
    val password: String

)