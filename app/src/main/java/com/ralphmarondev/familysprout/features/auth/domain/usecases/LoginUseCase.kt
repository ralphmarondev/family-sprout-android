package com.ralphmarondev.familysprout.features.auth.domain.usecases

import com.ralphmarondev.familysprout.features.auth.domain.repositories.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(username: String, password: String): Boolean {
        return authRepository.login(username, password)
    }
}