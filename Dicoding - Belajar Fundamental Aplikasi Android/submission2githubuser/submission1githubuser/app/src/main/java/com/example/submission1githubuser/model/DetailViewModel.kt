package com.example.submission1githubuser.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submission1githubuser.data.repository.UserRepository
import com.example.submission1githubuser.data.response.DetailUser
import com.example.submission1githubuser.data.response.GithubUser
import com.example.submission1githubuser.data.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Response

class DetailViewModel(mAppk: Application) : ViewModel() {

    private val _datauser = MutableLiveData<DetailUser>()
    val datauser: LiveData<DetailUser> = _datauser

    private val _userfollowers = MutableLiveData<List<GithubUser>>()
    val userfollowers: LiveData<List<GithubUser>> = _userfollowers

    private val _userfollowings = MutableLiveData<List<GithubUser>>()
    val userfollowings: LiveData<List<GithubUser>> = _userfollowings

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isLoadingUserFollower = MutableLiveData<Boolean>()
    val isLoadingUserFollower: LiveData<Boolean> = _isLoadingUserFollower

    private val _isLoadingUserFollowing = MutableLiveData<Boolean>()
    val isLoadingUserFollowing: LiveData<Boolean> = _isLoadingUserFollowing

    private val UserData: UserRepository = UserRepository(mAppk)

    fun getAllUsers(): LiveData<List<GithubUser>> = UserData.getAllData()
    fun insertDataUser(user: GithubUser) {
        UserData.insertUser(user)
    }

    fun deleteDataUser(user: GithubUser) {
        UserData.deleteUser(user)
    }


    fun setUserLogin(userLogin: String) {
        getUser(userLogin)
        getUserFollowers(userLogin)
        getUserFollowings(userLogin)
    }

    companion object {
        private const val TAG = "DetailViewModel"
    }


    private fun getUser(userLogin: String) {
        _isLoading.value = true
        val api = ApiConfig.getApiService().getDetailUser(userLogin)
        api.enqueue(object : retrofit2.Callback<DetailUser> {
            override fun onResponse(call: Call<DetailUser>, response: Response<DetailUser>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    _datauser.value = responseBody!!
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailUser>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun getUserFollowers(userLogin: String) {
        _isLoadingUserFollower.value = true
        val api = ApiConfig.getApiService().getAllFollowers(userLogin)
        api.enqueue(object : retrofit2.Callback<List<GithubUser>> {
            override fun onResponse(
                call: Call<List<GithubUser>>,
                response: Response<List<GithubUser>>
            ) {
                _isLoadingUserFollower.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    _userfollowers.value = responseBody!!
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                _isLoadingUserFollower.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

    private fun getUserFollowings(userLogin: String) {
        _isLoadingUserFollowing.value = true
        val api = ApiConfig.getApiService().getAllFollowings(userLogin)
        api.enqueue(object : retrofit2.Callback<List<GithubUser>> {
            override fun onResponse(
                call: Call<List<GithubUser>>,
                response: Response<List<GithubUser>>
            ) {
                _isLoadingUserFollowing.value = false
                if (response.isSuccessful) {
                    val responseBody = response.body()
                    _userfollowings.value = responseBody!!
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                _isLoadingUserFollowing.value = false
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })
    }

}