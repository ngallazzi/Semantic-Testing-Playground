package com.ngallazzi.semantictestingplayground.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ngallazzi.semantictestingplayground.R
import com.ngallazzi.semantictestingplayground.Screens
import com.ngallazzi.semantictestingplayground.ui.screens.CreditsScreen
import com.ngallazzi.semantictestingplayground.ui.screens.SwitchScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController) {
    val context = LocalContext.current
    NavHost(
        navController = navController,
        startDestination = Screens.SWITCH.destination,
        modifier = modifier
    ) {
        composable(Screens.SWITCH.destination) {
            SwitchScreen(modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.switch_screen_description)
            }, onGoToCreditsClick = {
                navController.navigate(Screens.CREDITS.destination)
            })
        }
        composable(Screens.CREDITS.destination) {
            CreditsScreen(modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.credits_screen_description)
            }, onBackPressed = {
                navController.popBackStack()
            })
        }
    }
}

