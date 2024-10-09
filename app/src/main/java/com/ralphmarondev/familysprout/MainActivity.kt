package com.ralphmarondev.familysprout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ralphmarondev.familysprout.core.preference.ThemeManager
import com.ralphmarondev.familysprout.navigation.AppNavigation
import com.ralphmarondev.familysprout.ui.theme.FamilySproutTheme

class MainActivity : ComponentActivity() {
    private lateinit var themeManager: ThemeManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()

        themeManager = ThemeManager(this)
        setContent {
            val isDarkTheme by themeManager.isDarkTheme.collectAsState(initial = false)

            FamilySproutTheme(darkTheme = isDarkTheme) {
                AppNavigation(
                    darkTheme = isDarkTheme,
                    toggleDarkTheme = {
                        themeManager.saveThemePreference(!isDarkTheme)
                    }
                )
            }
        }
    }
}