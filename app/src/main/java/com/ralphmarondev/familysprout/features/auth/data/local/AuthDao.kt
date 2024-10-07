package com.ralphmarondev.familysprout.features.auth.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.ralphmarondev.familysprout.core.model.User

@Dao
interface AuthDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE username=:username and password=:password")
    suspend fun login(username: String, password: String): User?
}