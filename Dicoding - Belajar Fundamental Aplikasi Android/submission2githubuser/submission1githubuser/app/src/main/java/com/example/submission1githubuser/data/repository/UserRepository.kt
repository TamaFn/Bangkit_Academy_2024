package com.example.submission1githubuser.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.submission1githubuser.data.database.UserDao
import com.example.submission1githubuser.data.database.UserDatabase
import com.example.submission1githubuser.data.response.GithubUser
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class  UserRepository(application: Application) {
    private val userDao: UserDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

//  Dalam deklarasi init, harus primary constructor dan init harus saling terhubung
    init {
        val db = UserDatabase.getDatabase(application)
        userDao = db.userDao()
    }

    fun insertUser(user: GithubUser) {
        executorService.execute { userDao.insert(user) }
    }

    fun deleteUser(user: GithubUser) {

        executorService.execute { userDao.delete(user) }
    }

    fun getAllData(): LiveData<List<GithubUser>> = userDao.getAllDataUsers()

    fun removeAllData(): Unit = userDao.removeAllDataUsers()


}