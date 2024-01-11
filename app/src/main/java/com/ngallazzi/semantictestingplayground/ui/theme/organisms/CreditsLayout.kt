package com.ngallazzi.semantictestingplayground.ui.theme.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.ngallazzi.semantictestingplayground.R
import com.ngallazzi.semantictestingplayground.backgroundColor
import com.ngallazzi.semantictestingplayground.ui.theme.atoms.CreditsBackgroundColor

@Composable
fun CreditsLayout(modifier: Modifier = Modifier, onClick: () -> Unit) {
    val context = LocalContext.current
    Box(modifier = modifier
        .fillMaxWidth()
        .background(
            color = CreditsBackgroundColor
        )
        .semantics(mergeDescendants = true) {
            contentDescription = context.getString(R.string.credits_and_copyright_section_desc)
            backgroundColor = CreditsBackgroundColor
        }) {
        val textBackgroundColor = MaterialTheme.colorScheme.onPrimary
        Text(
            modifier = Modifier
                .padding(8.dp)
                .clickable(onClickLabel = context.getString(R.string.go_to_credits),
                    onClick = { onClick.invoke() })
                .semantics { backgroundColor = textBackgroundColor },
            text = stringResource(id = R.string.credits),
            style = MaterialTheme.typography.bodyLarge.copy(color = textBackgroundColor)
        )
    }
}