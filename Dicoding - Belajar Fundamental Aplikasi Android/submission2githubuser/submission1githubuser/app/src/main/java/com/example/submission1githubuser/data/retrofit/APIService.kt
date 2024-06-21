package com.example.submission1githubuser.data.retrofit

import com.example.submission1githubuser.data.response.DetailUser
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.data.response.SearchUsers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {

//   @Header: Digunakan untuk menambahkan header HTTP ke permintaan.
//   Header-header ini bisa digunakan untuk berbagai keperluan, seperti otentikasi, memberikan informasi tambahan kepada server, atau menentukan jenis konten yang diterima
    @GET("users")
    fun getUsers(
        @Header("Authorization") token: String
    ): Call<List<GithubUser>>


//    @Query: Digunakan untuk menambahkan parameter ke URL permintaan sebagai query string.
//    Parameter-parameter ini biasanya digunakan untuk menyaring, mengurutkan, atau menentukan jenis data yang akan diperoleh dari server
    @GET("search/users")
    fun getUserSearch(
        @Query("q") login: String,
    ): Call<SearchUsers>


//  @Path: Digunakan untuk menentukan bagian dari URL permintaan yang akan digantikan dengan nilai yang diberikan pada saat panggilan metode.
//  Ini berguna ketika Anda ingin menyertakan nilai dinamis dalam URL, seperti ID pengguna atau nama pengguna
    @GET("users/{login}")
    fun getDetailUser(
        @Path("login") login: String,
    ): Call<DetailUser>

    @GET("users/{login}/followers")
    fun getAllFollowers(
        @Path("login") login: String,
    ): Call<List<GithubUser>>

    //memanggil list following
    @GET("users/{login}/following")
    fun getAllFollowings(
        @Path("login") login: String,
    ): Call<List<GithubUser>>
}