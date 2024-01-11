package com.ngallazzi.semantictestingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ngallazzi.semantictestingplayground.ui.screens.CreditsScreen
import com.ngallazzi.semantictestingplayground.ui.screens.SwitchScreen
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SemanticsTestingPlaygroundTheme {
                Scaffold(content = {
                    NavHost(
                        navController = navController,
                        startDestination = Screens.SWITCH.destination,
                        modifier = Modifier.padding(it)
                    ) {
                        composable(Screens.SWITCH.destination) {
                            SwitchScreen(onGoToCreditsClick = {
                                navController.navigate(Screens.CREDITS.destination)
                            })
                        }
                        composable(Screens.CREDITS.destination) {
                            CreditsScreen(onBackPressed = {
                                navController.popBackStack()
                            })
                        }
                    }
                })
            }
        }
    }
}
