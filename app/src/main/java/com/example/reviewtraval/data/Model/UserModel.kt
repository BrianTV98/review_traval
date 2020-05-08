package com.example.reviewtraval.data.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("username")
    @Expose
    val userName: String,

    @SerializedName("password")
    @Expose
    val password: String,

    @SerializedName("firstname")
    @Expose
    val firstname: String,

    @SerializedName("lastname")
    @Expose
    val lastname: String,

    @SerializedName("email")
    @Expose
    val email: String

)