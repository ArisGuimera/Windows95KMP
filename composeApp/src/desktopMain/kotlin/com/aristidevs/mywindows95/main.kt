package com.aristidevs.mywindows95

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val state = rememberWindowState(
        width = 1200.dp,
        height = 900.dp
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Windows95",
        resizable = false,
        state = state
    ) {
        App()
    }
}