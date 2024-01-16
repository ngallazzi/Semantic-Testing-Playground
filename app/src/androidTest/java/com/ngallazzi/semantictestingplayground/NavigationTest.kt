package com.ngallazzi.semantictestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.ngallazzi.semantictestingplayground.ui.navigation.AppNavHost
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class NavigationTest {
    // Create test rule, we need android context so we use createAndroidComposeRule factory method
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()
    lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavHost(navController = navController)
        }
    }

    // Unit test
    @Test
    fun appNavHost_verifyStartDestination() {
        val context = composeTestRule.activity
        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.switch_screen))
            .assertIsDisplayed()
    }
}