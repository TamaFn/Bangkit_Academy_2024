package com.example.submissionone.data.retrofit

import com.example.submissionone.data.response.ItemsItem
import com.example.submissionone.data.response.ResponseUser
import com.example.submissionone.data.response.SearchGithub
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    fun User(): Call<List<ItemsItem>>

    @GET("search/users")
    fun searchUser(
        @Query("q") query: String
    ): Call<SearchGithub>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ): Call<ResponseUser>

    @GET("users/{username}/followers")
    fun getFollower(
        @Path("username") username: String
    ): Call<List<ItemsItem>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String
    ): Call<List<ItemsItem>>

}