package com.example.submission1githubuser.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.ui.MainActivity
import com.example.submission1githubuser.data.response.SearchUsers
import com.example.submission1githubuser.data.retrofit.ApiConfig
import com.example.submission1githubuser.BuildConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

//  _user adalah MutableLiveData yang digunakan untuk memodifikasi data di dalam ViewModel
    private val _user = MutableLiveData<List<GithubUser>>()
//  user adalah LiveData yang dipublikasikan ke luar ViewModel
    val user: LiveData<List<GithubUser>> = _user

    private val _listUser = MutableLiveData<List<GithubUser>>()
    val listUser: LiveData<List<GithubUser>> = _listUser

    private var _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getData()
    }

    private fun getData() {
        _isLoading.value = true
        val service = ApiConfig.getApiService().getUsers(BuildConfig.KEY)
        service.enqueue(object : Callback<List<GithubUser>> {
            override fun onResponse(
                call: Call<List<GithubUser>>,
                response: Response<List<GithubUser>>
            ) {
                _isLoading.value = false
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    _user.value = responseBody!!
                } else {
                    Log.e(MainActivity.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                _isLoading.value = false
                Log.e(MainActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }

    fun getDataSearch(query: String) {
        // Mengatur isLoading menjadi true untuk menampilkan indikator loading
        _isLoading.value = true

        // Memanggil metode getUserSearch dari ApiService menggunakan ApiConfig
        val service = ApiConfig.getApiService().getUserSearch(query)

        // Melakukan enqueue untuk menjalankan panggilan asinkron ke API
        service.enqueue(object : Callback<SearchUsers> {
            override fun onResponse(
                call: Call<SearchUsers>,
                response: Response<SearchUsers>
            ) {
                // Mengatur isLoading menjadi false setelah respons diterima
                _isLoading.value = false

                // Mendapatkan body respons dari API
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    // Memperbarui nilai listUser dengan daftar pengguna dari respons
                    _listUser.value = response.body()?.items
                } else {
                    Log.e(MainActivity.TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<SearchUsers>, t: Throwable) {
                _isLoading.value = false
                Log.e(MainActivity.TAG, "onFailure: ${t.message}")
            }
        })
    }




}