package com.example.reviewtraval.data.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class NewFeedModel(
    @SerializedName("id")
    @Expose
    val id : String,

    @SerializedName("comments")
    @Expose
    val comments : List<String>,


    @SerializedName("date_created")
    @Expose
    val date_created : Date,

    @SerializedName("title")
    @Expose
    val title : String,

    @SerializedName("slug")
    @Expose
    val slug : String,

    @SerializedName("content")
    @Expose
    val content : String,

    @SerializedName("tags")
    @Expose
    val tags : String,

    @SerializedName("owner")
    @Expose
    val owner : Int)

