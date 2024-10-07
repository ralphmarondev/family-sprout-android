package com.ralphmarondev.familysprout.features.auth.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ralphmarondev.familysprout.MyApplication
import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.data.repositories.AuthRepositoryImpl
import com.ralphmarondev.familysprout.features.auth.domain.usecases.LoginUseCase
import com.ralphmarondev.familysprout.features.auth.domain.usecases.RegisterUseCase
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {
    private val authDao = MyApplication.database.authDao()
    private val authRepository = AuthRepositoryImpl(authDao)
    private val loginUseCase = LoginUseCase(authRepository)
    private val registerUseCase = RegisterUseCase(authRepository)

    fun login(username: String, password: String, onSuccess: (User?) -> Unit) {
        viewModelScope.launch {
            val user = loginUseCase(username, password)
            onSuccess(user)
        }
    }

    fun register(user: User, onComplete: () -> Unit) {
        viewModelScope.launch {
            try {
                registerUseCase(user)
                onComplete()
            } catch (ex: Exception) {
                Log.d("AUTH", "Registration Error: ${ex.message}")
            }
        }
    }
}