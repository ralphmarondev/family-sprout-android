package com.ralphmarondev.familysprout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ralphmarondev.familysprout.navigation.AppNavigation
import com.ralphmarondev.familysprout.ui.theme.FamilySproutTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember { mutableStateOf(false) }

            FamilySproutTheme(darkTheme = darkTheme) {
                AppNavigation(
                    darkTheme = darkTheme,
                    toggleDarkTheme = { darkTheme = !darkTheme }
                )
            }
        }
    }
}