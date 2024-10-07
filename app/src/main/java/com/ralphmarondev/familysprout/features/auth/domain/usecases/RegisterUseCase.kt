package com.ralphmarondev.familysprout.features.auth.domain.usecases

import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.domain.repositories.AuthRepository

class RegisterUseCase(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User) {
        authRepository.registerUser(user)
    }
}