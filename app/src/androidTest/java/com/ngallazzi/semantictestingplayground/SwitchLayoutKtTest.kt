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
        Thread.sleep(2000)
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(R.string.on_button_description)
        ).performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.current_status_description))
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
        // Click on on button to to enable off button
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(
                R.string.on_button_description
            )
        ).performClick()
        Thread.sleep(2000)
        // Click off button
        composeTestRule.onNodeWithContentDescription(
            composeTestRule.activity.getString(R.string.off_button_description)
        ).performClick()
        composeTestRule.onNodeWithContentDescription(composeTestRule.activity.getString(R.string.current_status_description))
            .assertTextEquals("Status is: ${SwitchStatus.OFF.name}")

    }
}