package com.ngallazzi.semantictestingplayground.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.ngallazzi.semantictestingplayground.R
import com.ngallazzi.semantictestingplayground.ui.theme.molecules.HyperlinkText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreditsScreen(onBackPressed: () -> Unit) {
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(modifier = Modifier.semantics {
            contentDescription = context.getString(R.string.credits_screen_description)
        }, title = { Text(text = context.getString(R.string.credits_screen_description)) }, navigationIcon = {
            IconButton(
                onClick = onBackPressed
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = context.getString(R.string.back_to_switch_screen)
                )
            }
        })
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HyperlinkText(
                modifier = Modifier.semantics {
                    contentDescription =
                        context.getString(R.string.navigate_credits_link)
                },
                fullText = stringResource(R.string.thanks_to_credits),
                hyperlinks = listOf(
                    "https://developer.android.com/jetpack/compose/testing",
                    "https://www.amazon.com/Android-Development-Jetpack-Compose-declarative/dp/1801812160"
                ),
                linkText = listOf(
                    stringResource(R.string.android_documentation_string_placeholder),
                    stringResource(
                        R.string.thomas_kunnet_book_placeholder
                    )
                )
            )
        }
    }
}