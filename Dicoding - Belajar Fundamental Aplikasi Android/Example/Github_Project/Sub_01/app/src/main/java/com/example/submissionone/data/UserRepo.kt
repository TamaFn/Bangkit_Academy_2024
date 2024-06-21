package com.example.submissionone.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.submissionone.data.database.entity.EntityUser
import com.example.submissionone.data.database.room.UserDatabase
import com.example.submissionone.data.database.room.UserDataobject
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class UserRepo(application: Application) {
    private val userDao: UserDataobject
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val database = UserDatabase.getDatabase(application)
        userDao = database.userDao()
    }

    fun getAllFavorite(): LiveData<List<EntityUser>> = userDao.getAllFavoriteData()

    fun insertUser(user: EntityUser) {
        executorService.execute {
            userDao.insert((user))
        }
    }

    fun deleteUser(user: EntityUser) {
        executorService.execute {
            userDao.delete(user)
        }
    }

    fun getDataByUsername(username: String): LiveData<List<EntityUser>> = userDao.getDataByUsername(username)
}