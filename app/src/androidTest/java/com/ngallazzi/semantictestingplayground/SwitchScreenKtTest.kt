package com.ngallazzi.semantictestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme
import org.junit.Rule
import org.junit.Test


class SwitchScreenKtTest {
    // Create test rule, we need android context so we use createAndroidComposeRule factory method
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testButtonOn_setsOnState() {
        val context = composeTestRule.activity
        val onButtonNodeIdentifier = context.getString(R.string.on_button_description)
        val currentStatusNodeIdentifier = context.getString(R.string.current_status_description)
        val lampImageNodeIdentifier = context.getString(R.string.pacman_lamp_image_description)
        // Start the app
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchScreen(onGoToCreditsClick = {})
            }
        }
        // Prints semantics tree
        composeTestRule.onRoot().printToLog("SwitchScreenTests")
        Thread.sleep(2000)
        // Perform click action on "on button", using its semantics matcher
        composeTestRule.onNodeWithContentDescription(onButtonNodeIdentifier).performClick()
        // Assert status text switches to "on status"
        composeTestRule.onNodeWithContentDescription(currentStatusNodeIdentifier)
            .assertTextEquals("Status is: ${SwitchStatus.ON.name}")
        // Assert image is "on" image
        composeTestRule.onNodeWithContentDescription(lampImageNodeIdentifier).assert(
            SemanticsMatcher.expectValue(DrawableIdSemanticsProperty, SwitchStatus.ON.imageRes)
        )
    }

    @Test
    fun testButtonOff_setsOffState() {
        val context = composeTestRule.activity
        val onButtonNodeIdentifier = context.getString(R.string.on_button_description)
        val offButtonNodeIdentifier = context.getString(R.string.off_button_description)
        val currentStatusNodeIdentifier = context.getString(R.string.current_status_description)
        val lampImageNodeIdentifier = context.getString(R.string.pacman_lamp_image_description)
        // Start the app
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchScreen(onGoToCreditsClick = {})
            }
        }
        // Prints semantics tree
        composeTestRule.onRoot().printToLog("SwitchScreenTests")
        // Click on on button to to enable off button
        composeTestRule.onNodeWithContentDescription(onButtonNodeIdentifier).performClick()
        Thread.sleep(2000)
        // Click off button
        composeTestRule.onNodeWithContentDescription(offButtonNodeIdentifier).performClick()
        composeTestRule.onNodeWithContentDescription(currentStatusNodeIdentifier)
            .assertTextEquals("Status is: ${SwitchStatus.OFF.name}")
        // Assert image is "off" image
        composeTestRule.onNodeWithContentDescription(lampImageNodeIdentifier).assert(
            SemanticsMatcher.expectValue(DrawableIdSemanticsProperty, SwitchStatus.OFF.imageRes)
        )
    }
}