package com.ngallazzi.semantictestingplayground

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun SwitchLayout(
    status: SwitchStatus,
    onButtonONClick: () -> Unit,
    onButtonOFFClick: () -> Unit
) {
    val context = LocalContext.current

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(32.dp)) {
        Image(
            modifier = Modifier
                .width(196.dp)
                .semantics {
                    contentDescription =
                        context.getString(R.string.pacman_lamp_image_description, status.name)
                },
            painter = painterResource(id = status.imageRes),
            contentDescription = stringResource(R.string.pacman_lamp_image_description, status.name)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Status is: ${status.name}", modifier = Modifier.semantics {
            contentDescription = context.getString(R.string.status_description)
        }, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(
                enabled = status == SwitchStatus.ON,
                onClick = onButtonOFFClick,
                modifier = Modifier.semantics {
                    contentDescription =
                        context.getString(R.string.switch_state_description, SwitchStatus.OFF.name)
                }) {
                Text(SwitchStatus.OFF.name)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Button(
                enabled = status == SwitchStatus.OFF,
                onClick = onButtonONClick,
                modifier = Modifier.semantics {
                    contentDescription =
                        context.getString(R.string.switch_state_description, SwitchStatus.ON.name)
                }) {
                Text(SwitchStatus.ON.name)
            }
        }
    }
}

@Composable
@Preview
private fun SwitchLayoutOff() {
    SemanticsTestingPlaygroundTheme {
        SwitchLayout(status = SwitchStatus.OFF, onButtonONClick = {}, onButtonOFFClick = {})
    }
}

@Composable
@Preview
private fun SwitchLayoutOn() {
    SemanticsTestingPlaygroundTheme {
        SwitchLayout(status = SwitchStatus.ON, onButtonONClick = {}, onButtonOFFClick = {})
    }
}