package com.ngallazzi.semantictestingplayground.ui.theme.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
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
import com.ngallazzi.semantictestingplayground.R
import com.ngallazzi.semantictestingplayground.backgroundColor
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme
import com.ngallazzi.semantictestingplayground.ui.theme.atoms.CreditsBackgroundColor

@Composable
fun CreditsLayout(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val context = LocalContext.current
    val textBackgroundColor = MaterialTheme.colorScheme.onPrimary
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = CreditsBackgroundColor
            )
            .semantics(mergeDescendants = true) {
                contentDescription = context.getString(R.string.credits_and_copyright_section_desc)
                backgroundColor = CreditsBackgroundColor
            }, verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_credits),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .clickable(onClickLabel = context.getString(R.string.go_to_credits),
                    onClick = { onClick.invoke() })
                .semantics { backgroundColor = textBackgroundColor },
            text = stringResource(id = R.string.credits),
            style = MaterialTheme.typography.bodyLarge.copy(color = textBackgroundColor)
        )
    }
}

@Composable
@Preview
private fun Preview() {
    SemanticsTestingPlaygroundTheme {
        CreditsLayout(onClick = {})
    }
}