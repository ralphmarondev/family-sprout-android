package com.ralphmarondev.familysprout.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.familysprout.features.auth.presentation.AuthScreen
import com.ralphmarondev.familysprout.features.home.presentation.HomeScreen
import com.ralphmarondev.familysprout.features.newfamily.presentation.NewFamilyScreen
import kotlinx.serialization.Serializable

class Screens {
    @Serializable
    data object Auth

    @Serializable
    data object Home

    @Serializable
    data object NewFamily
}

@Composable
fun AppNavigation(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Auth
    ) {
        composable<Screens.Auth> {
            AuthScreen(
                darkTheme = darkTheme,
                toggleDarkTheme = toggleDarkTheme,
                navigateToHome = { navController.navigate(Screens.Home) }
            )
        }
        composable<Screens.Home> {
            HomeScreen(
                logout = { navController.navigateUp() },
                navigateToNewFamily = { navController.navigate(Screens.NewFamily) },
                navigateToFamilyList = {}
            )
        }
        composable<Screens.NewFamily> {
            NewFamilyScreen(
                onBack = { navController.navigateUp() }
            )
        }
    }
}