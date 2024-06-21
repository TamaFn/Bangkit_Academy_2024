package com.example.submissionone.data.database.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.submissionone.data.database.entity.EntityUser

@Dao
interface UserDataobject {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: EntityUser)

    @Delete
    fun delete(user: EntityUser)

    @Query("SELECT * FROM FavoriteUser ORDER BY username ASC")
    fun getAllFavoriteData(): LiveData<List<EntityUser>>

    @Query("SELECT * FROM FavoriteUser WHERE username = :username")
    fun getDataByUsername(username: String): LiveData<List<EntityUser>>
}