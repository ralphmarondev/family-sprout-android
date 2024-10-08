package com.ralphmarondev.familysprout.features.auth.domain.repositories

import com.ralphmarondev.familysprout.core.model.User

interface AuthRepository {
    suspend fun login(username: String, password: String): Boolean
    suspend fun registerUser(user: User)
    suspend fun isUsernameTaken(username: String): Boolean
}