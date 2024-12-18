package com.aristidevs.mywindows95.components.rightmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.components.BackgroundComponent

@Composable
fun SubMenu() {
    BackgroundComponent(Modifier.width(170.dp)) {
        Column(Modifier.padding(3.dp)) {
            MenuItem(text = "Line up Icons", hovered = { })
            MenuItem(text = "Line up Icons", hovered = { })
            MenuItem(text = "Line up Icons", hovered = { })
            MenuDivider()
            MenuItem(text = "Paste", enabled = false, hovered = {})
        }
    }
}