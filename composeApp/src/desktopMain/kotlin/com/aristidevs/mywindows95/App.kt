package com.aristidevs.mywindows95

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.aristidevs.mywindows95.splash.SplashScreen
import com.aristidevs.mywindows95.ui.Windows95Typography
import com.aristidevs.mywindows95.ui.background
import com.aristidevs.mywindows95.windows95.Windows95Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(typography = Windows95Typography()) {
        var initializing: Boolean by remember { mutableStateOf(true) }

        Box(Modifier.fillMaxSize().background(background)) {
            if (initializing) {
                SplashScreen { initializing = false }
            } else {
                Windows95Screen()
            }
        }
    }
}

