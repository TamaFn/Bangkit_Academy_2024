package com.example.submission1githubuser.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.submission1githubuser.data.response.GithubUser

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: GithubUser)

    @Delete
    fun delete(user: GithubUser)

    @Query("SELECT * from GithubUser ORDER BY login DESC")
    fun getAllDataUsers(): LiveData<List<GithubUser>>

    @Query("DELETE FROM GithubUser")
    fun removeAllDataUsers()

}