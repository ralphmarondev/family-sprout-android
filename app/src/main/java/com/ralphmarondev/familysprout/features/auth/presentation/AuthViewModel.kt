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

    fun login(username: String, password: String, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val isAuthenticated = loginUseCase(username, password)
                onComplete(isAuthenticated)
            } catch (ex: Exception) {
                Log.d("AUTH", "Login Error: ${ex.message}")
                onComplete(false)
            }
        }
    }

    fun register(user: User, onComplete: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                val isTaken = registerUseCase.isUsernameTaken(user.username)

                if (isTaken) {
                    onComplete(false, "Username is already taken.")
                } else {
                    registerUseCase.registerUser(user)
                    onComplete(true, null)
                }
            } catch (ex: Exception) {
                Log.d("AUTH", "Registration Error: ${ex.message}")
                onComplete(false, ex.message)
            }
        }
    }
}