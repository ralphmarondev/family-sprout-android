package com.ralphmarondev.familysprout.features.auth.presentation

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ralphmarondev.familysprout.core.model.User
import com.ralphmarondev.familysprout.features.auth.presentation.login.LoginScreen
import com.ralphmarondev.familysprout.features.auth.presentation.register.RegisterScreen

@Composable
fun AuthScreen(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: AuthViewModel = viewModel()
) {
    val context = LocalContext.current
    var selectedScreen by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            AuthScreenTopBar(
                darkTheme = darkTheme,
                toggleDarkTheme = toggleDarkTheme
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedVisibility(selectedScreen == 0) {
                        LoginScreen(
                            goToRegister = { selectedScreen = 1 },
                            onLogin = { username, password ->
                                viewModel.login(username, password) { isAuthenticated ->
                                    if (isAuthenticated) {
                                        navigateToHome()
                                    } else {
                                        Toast.makeText(context, "Login Failed!", Toast.LENGTH_SHORT)
                                            .show()
                                    }
                                }
                            }
                        )
                    }

                    AnimatedVisibility(selectedScreen == 1) {
                        RegisterScreen(
                            backToLogin = { selectedScreen = 0 },
                            onRegister = { fullName, username, password ->
                                viewModel.register(
                                    user = User(
                                        fullName = fullName,
                                        username = username,
                                        password = password
                                    )
                                ) { isSuccess, response ->
                                    if (isSuccess) {
                                        Toast.makeText(
                                            context,
                                            "User registered successfully!",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        selectedScreen = 0
                                    } else {
                                        Toast.makeText(
                                            context,
                                            "Failed registering user. $response",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AuthScreenTopBar(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Authentication",
                fontFamily = FontFamily.Monospace
            )
        },
        actions = {
            IconButton(
                onClick = toggleDarkTheme
            ) {
                val icon = if (darkTheme) Icons.Outlined.LightMode else Icons.Outlined.DarkMode

                Icon(
                    imageVector = icon,
                    contentDescription = ""
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}