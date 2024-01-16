package com.ngallazzi.semantictestingplayground.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ngallazzi.semantictestingplayground.Screens
import com.ngallazzi.semantictestingplayground.ui.screens.CreditsScreen
import com.ngallazzi.semantictestingplayground.ui.screens.SwitchScreen


@Composable
fun AppNavHost(modifier : Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.SWITCH.destination,
        modifier = modifier
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
}

