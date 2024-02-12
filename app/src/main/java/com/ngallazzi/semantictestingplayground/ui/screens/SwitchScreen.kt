package com.ngallazzi.semantictestingplayground.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngallazzi.semantictestingplayground.R
import com.ngallazzi.semantictestingplayground.SwitchStatus
import com.ngallazzi.semantictestingplayground.drawableId
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme
import com.ngallazzi.semantictestingplayground.ui.theme.organisms.CreditsLayout

const val IMAGE_TEST_TAG = "status_image"

@Composable
fun SwitchScreen(
    modifier: Modifier = Modifier,
    initialState: SwitchStatus = SwitchStatus.OFF,
    onGoToCreditsClick: () -> Unit
) {
    val context = LocalContext.current
    var status: SwitchStatus by remember {
        mutableStateOf(initialState)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(top = 32.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 32.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(196.dp)
                    .semantics {
                        drawableId = status.imageRes
                        testTag = IMAGE_TEST_TAG
                    },
                painter = painterResource(id = status.imageRes),
                contentDescription = stringResource(
                    R.string.pacman_lamp_image_description,
                    status.name
                ),
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Status is: ${status.name}", modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.current_status_description)
            }, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                // OFF button
                Button(enabled = status == SwitchStatus.ON,
                    onClick = { status = SwitchStatus.OFF },
                    modifier = Modifier.semantics(mergeDescendants = true) {
                        contentDescription = context.getString(R.string.off_button_description)
                    }) {
                    Text(SwitchStatus.OFF.name, modifier = Modifier.clearAndSetSemantics { })
                }
                Spacer(modifier = Modifier.width(32.dp))
                // ON Button
                Button(enabled = status == SwitchStatus.OFF,
                    onClick = { status = SwitchStatus.ON },
                    modifier = Modifier.semantics(mergeDescendants = true) {
                        contentDescription = context.getString(R.string.on_button_description)
                    }) {
                    Text(SwitchStatus.ON.name, modifier = Modifier.clearAndSetSemantics { })
                }
            }
            Spacer(Modifier.height(48.dp))
        }
        CreditsLayout(onClick = onGoToCreditsClick)
    }
}

@Composable
@Preview
private fun SwitchLayoutPreview() {
    SemanticsTestingPlaygroundTheme {
        SwitchScreen(onGoToCreditsClick = {})
    }
}