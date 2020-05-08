package com.example.reviewtraval.data.api

import com.example.reviewtraval.data.Model.NewFeedModel
import com.example.reviewtraval.data.api.response.*
import retrofit2.Call
import retrofit2.http.*

interface AppReponsitory {

    @GET("/post/list/")
    fun createNewFeed(): Call<List<NewFeedModel>>

    @FormUrlEncoded
    @POST("/check-activate/")
    fun checkActivtate(
        @Field("api_token")  api_token :String
    ) : Call <TokenActiveResponse>


    @FormUrlEncoded
    @POST("/login/")
    fun login(
        @Field("username")  username :String,
        @Field("password")  password :String
    ) : Call <LoginResponse>

    @FormUrlEncoded
    @POST("/post/")
    fun postNewFeed(
        @Field("title") title: String,
        @Field("content") content: String,
        @Field("tags") tags: String
    ): Call<ResultResponse>

    @FormUrlEncoded
    @PUT("/post/")
    fun putNewFeed(
        @Field("post_id") post_id : String,
        @Field("title") title : String,
        @Field("content") content: String,
        @Field("tags") tags : String
    ) : Call<PostResponse>

    @DELETE("/post/delete/{post_id}/")
    fun  deleteNewFeed(
        @Path("post_id") post_id: String
    ) : Call<PostResponse>

    @FormUrlEncoded
    @POST("/users/create-user/")
    fun createUserName(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("firstname") firstname: String,
        @Field("lastname") lastname: String,
        @Field("email") email: String
    ): Call<CreateUserResponse>

}