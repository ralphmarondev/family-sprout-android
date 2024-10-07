package com.ralphmarondev.familysprout.features.auth.presentation

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ralphmarondev.familysprout.core.model.User

@Composable
fun AuthScreen(viewModel: AuthViewModel = viewModel()) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            AuthScreenTopBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.register(
                        user = User(
                            fullName = "Ralph Maron Eda",
                            username = "ralphmaron",
                            password = "iscute"
                        ),
                        onComplete = {}
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") })
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") })

            errorMessage?.let {
                Text(text = it, color = Color.Red)
            }

            Button(
                onClick = {
                    viewModel.login(username, password) { user ->
                        if (user != null) {
                            // go home
                            Log.d("AUTH", "Login Success. Going Home.")
                        } else {
                            // show error
                            errorMessage = "Login failed. Please try again."
                        }
                    }
                }
            ) {
                Text(text = "LOGIN")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AuthScreenTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Authentication",
                fontFamily = FontFamily.Monospace
            )
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.Outlined.LightMode,
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