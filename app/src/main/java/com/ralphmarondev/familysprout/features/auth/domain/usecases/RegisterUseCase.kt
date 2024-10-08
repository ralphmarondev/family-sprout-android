package com.ralphmarondev.familysprout.features.auth.domain.usecases

import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.domain.repositories.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) {
    suspend fun registerUser(user: User) {
        authRepository.registerUser(user)
    }

    suspend fun isUsernameTaken(username: String): Boolean {
        return authRepository.isUsernameTaken(username)
    }
}