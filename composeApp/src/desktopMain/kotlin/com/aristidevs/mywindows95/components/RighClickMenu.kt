package com.aristidevs.mywindows95.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.aristidevs.mywindows95.components.rightmenu.MenuDivider
import com.aristidevs.mywindows95.components.rightmenu.MenuItem
import com.aristidevs.mywindows95.components.rightmenu.SubMenu

@Composable
fun RightClickMenu(showMenu: Boolean, position: IntOffset, onDismissRequest: () -> Unit) {

    var subMenuPosition: Offset? by remember { mutableStateOf(null) }

    AnimatedVisibility(showMenu, exit = ExitTransition.None, enter = fadeIn()) {
        Popup(
            offset = position,
            onDismissRequest = { onDismissRequest() },
            alignment = Alignment.TopStart
        ) {
            BackgroundComponent(Modifier.width(170.dp)) {
                Column(Modifier.padding(3.dp)) {
                    MenuItem(text = "Arrange Icons", showSubMenu = true, hovered = { position ->
                        subMenuPosition = position
                    })
                    MenuItem(text = "Line up Icons", hovered = { subMenuPosition = null })
                    MenuDivider()
                    MenuItem(text = "Paste", enabled = false, hovered = { subMenuPosition = null })
                    MenuItem(text = "Paste Shortcut",
                        enabled = false,
                        hovered = { subMenuPosition = null })
                    MenuItem(text = "Undo Copy", hovered = { subMenuPosition = null })
                    MenuDivider()
                    MenuItem(text = "New", showSubMenu = true, hovered = { position ->
                        subMenuPosition = position
                    })
                    MenuDivider()
                    MenuItem(text = "Properties", onClick = {
                        //abrir properties
                        onDismissRequest()
                    }, hovered = { subMenuPosition = null })
                }
            }
            subMenuPosition?.let {
                SubMenu(offset = it)
            }
        }
    }
}