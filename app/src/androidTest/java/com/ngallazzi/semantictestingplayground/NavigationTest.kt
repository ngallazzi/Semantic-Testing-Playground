package com.ngallazzi.semantictestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
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

    @Test
    fun appNavHost_verifyNavigationToCreditsScreen() {
        val context = composeTestRule.activity
        // Verify initial screen is "switch" screen
        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.switch_screen_description))
            .assertIsDisplayed()
        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.go_to_credits))
            .performClick()
        // Verify app has switched to "credits" screen
        composeTestRule
            .onNodeWithContentDescription(context.getString(R.string.credits_screen_description))
            .assertIsDisplayed()
    }
}