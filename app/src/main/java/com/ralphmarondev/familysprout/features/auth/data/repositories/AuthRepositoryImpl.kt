package com.ralphmarondev.familysprout.features.auth.data.repositories

import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.data.local.AuthDao
import com.ralphmarondev.familysprout.features.auth.domain.repositories.AuthRepository

class AuthRepositoryImpl(
    private val authDao: AuthDao
) : AuthRepository {

    override suspend fun login(username: String, password: String): Boolean {
        return authDao.login(username, password)
    }

    override suspend fun registerUser(user: User) {
        return authDao.insertUser(user)
    }

    override suspend fun isUsernameTaken(username: String): Boolean {
        return authDao.isUsernameTaken(username)
    }
}