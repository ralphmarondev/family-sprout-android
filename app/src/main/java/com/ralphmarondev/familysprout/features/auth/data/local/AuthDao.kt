package com.ralphmarondev.familysprout.features.auth.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ralphmarondev.familysprout.core.model.User

@Dao
interface AuthDao {
    @Query("SELECT EXISTS(SELECT * FROM User WHERE username=:username)")
    suspend fun isUsernameTaken(username: String): Boolean

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: User)

    @Query("SELECT EXISTS(SELECT * FROM user WHERE username=:username AND password=:password)")
    suspend fun login(username: String, password: String): Boolean
}