package com.ngallazzi.semantictestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import com.ngallazzi.semantictestingplayground.ui.screens.IMAGE_TEST_TAG
import com.ngallazzi.semantictestingplayground.ui.screens.SwitchScreen
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme
import com.ngallazzi.semantictestingplayground.ui.theme.atoms.CreditsBackgroundColor
import com.ngallazzi.semantictestingplayground.ui.theme.organisms.CreditsLayout
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
        val lampImageNodeIdentifier = IMAGE_TEST_TAG
        // Start the app
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchScreen(onGoToCreditsClick = {})
            }
        }
        // Prints semantics tree
        composeTestRule.onRoot().printToLog("SwitchScreenTests")
        // Perform click action on "on button", using its semantics matcher
        composeTestRule.onNodeWithContentDescription(onButtonNodeIdentifier).performClick()
        Thread.sleep(2000)
        // Assert status text switches to "on status"
        composeTestRule.onNodeWithContentDescription(currentStatusNodeIdentifier)
            .assertTextEquals("Status is: ${SwitchStatus.ON.name}")
        // Assert image is "on" image
        composeTestRule.onNodeWithTag(lampImageNodeIdentifier).assert(
            SemanticsMatcher.expectValue(DrawableIdSemanticsProperty, SwitchStatus.ON.imageRes)
        )
        Thread.sleep(5000)
    }

    @Test
    fun testButtonOff_setsOffState() {
        val context = composeTestRule.activity
        val offButtonNodeIdentifier = context.getString(R.string.off_button_description)
        val currentStatusNodeIdentifier = context.getString(R.string.current_status_description)
        val lampImageNodeIdentifier = IMAGE_TEST_TAG
        // Start the app with status ON
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchScreen(onGoToCreditsClick = {}, initialState = SwitchStatus.ON)
            }
        }
        // Prints semantics tree
        composeTestRule.onRoot().printToLog("SwitchScreenTests")
        // Click off button
        composeTestRule.onNodeWithContentDescription(offButtonNodeIdentifier).performClick()
        Thread.sleep(2000)
        composeTestRule.onNodeWithContentDescription(currentStatusNodeIdentifier)
            .assertTextEquals("Status is: ${SwitchStatus.OFF.name}")
        // Assert image is "off" image
        composeTestRule.onNodeWithTag(lampImageNodeIdentifier).assert(
            SemanticsMatcher.expectValue(DrawableIdSemanticsProperty, SwitchStatus.OFF.imageRes)
        )
        Thread.sleep(5000)
    }

    @Test
    fun testCreditsLayout_backgroundSet() {
        val context = composeTestRule.activity
        val creditsLayoutNodeIdentifier =
            context.getString(R.string.credits_and_copyright_section_desc)
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                CreditsLayout(onClick = {})
            }
        }
        composeTestRule.onNodeWithContentDescription(creditsLayoutNodeIdentifier).assert(
            SemanticsMatcher.expectValue(
                BackgroundColorSemanticsProperty, CreditsBackgroundColor
            )
        )
    }
}