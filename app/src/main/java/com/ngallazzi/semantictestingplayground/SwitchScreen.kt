package com.ngallazzi.semantictestingplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme

@Composable
fun SwitchScreen(onGoToCreditsClick: () -> Unit) {
    val context = LocalContext.current
    var status: SwitchStatus by remember {
        mutableStateOf(SwitchStatus.OFF)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(32.dp)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                modifier = Modifier
                    .width(196.dp)
                    .semantics {
                        contentDescription =
                            context.getString(R.string.pacman_lamp_image_description)
                        drawableId = status.imageRes
                    },
                painter = painterResource(id = status.imageRes),
                contentDescription = stringResource(R.string.pacman_lamp_image_description)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Status is: ${status.name}", modifier = Modifier.semantics {
                contentDescription = context.getString(R.string.current_status_description)
            }, style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Button(enabled = status == SwitchStatus.ON,
                    onClick = { status = SwitchStatus.OFF },
                    modifier = Modifier.semantics {
                        contentDescription = context.getString(R.string.off_button_description)
                    }) {
                    Text(SwitchStatus.OFF.name)
                }
                Spacer(modifier = Modifier.width(32.dp))
                Button(enabled = status == SwitchStatus.OFF,
                    onClick = { status = SwitchStatus.ON },
                    modifier = Modifier.semantics {
                        contentDescription = context.getString(R.string.on_button_description)
                    }) {
                    Text(SwitchStatus.ON.name)
                }
            }
            Spacer(Modifier.height(48.dp))
        }
        Column(modifier = Modifier.semantics(mergeDescendants = true) {
            contentDescription = context.getString(R.string.credits_and_copyright_section_desc)
        }) {
            Text(
                modifier = Modifier.clickable {
                    onGoToCreditsClick.invoke()
                },
                text = stringResource(id = R.string.credits),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
@Preview
private fun SwitchLayoutPreview() {
    SemanticsTestingPlaygroundTheme {
        SwitchScreen(onGoToCreditsClick = {})
    }
}