package com.aristidevs.mywindows95

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val state = rememberWindowState(
        width = 1200.dp,
        height = 900.dp,
//        placement = WindowPlacement.Maximized
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Windows95",
        resizable = false,
        state = state,
        undecorated = true
    ) {
        App()
    }
}