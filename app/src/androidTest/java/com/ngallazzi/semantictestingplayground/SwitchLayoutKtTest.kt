package com.ngallazzi.semantictestingplayground

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme
import org.junit.Rule
import org.junit.Test


class SwitchLayoutKtTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testButtonOn_setsOnState() {
        // Start the app
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchLayout()
            }
        }
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(
                R.string.switch_state_description, SwitchStatus.ON.name
            )
        ).performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.status_description))
            .assertTextEquals("Status is: ${SwitchStatus.ON.name}")
    }

    @Test
    fun testButtonOff_setsOffState() {
        // Start the app
        composeTestRule.setContent {
            SemanticsTestingPlaygroundTheme {
                SwitchLayout()
            }
        }
        // Switch state to on to enable off button
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(
                R.string.switch_state_description, SwitchStatus.ON.name
            )
        ).performClick()
        // Click off button
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(
                R.string.switch_state_description, SwitchStatus.OFF.name
            )
        ).performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.status_description))
            .assertTextEquals("Status is: ${SwitchStatus.OFF.name}")
    }
}