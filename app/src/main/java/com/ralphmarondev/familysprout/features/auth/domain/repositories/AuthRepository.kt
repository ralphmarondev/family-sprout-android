package com.ralphmarondev.familysprout.features.auth.domain.repositories

import com.ralphmarondev.familysprout.core.model.User

interface AuthRepository {
    suspend fun login(username: String, password: String): User?
    suspend fun registerUser(user: User)
}