package com.ngallazzi.semantictestingplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ngallazzi.semantictestingplayground.ui.theme.SemanticsTestingPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SemanticsTestingPlaygroundTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SwitchLayout()
                }
            }
        }
    }
}
