package com.aristidevs.mywindows95.components.rightmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.components.BackgroundComponent
import com.aristidevs.mywindows95.model.SubMenuItem

@Composable
fun SubMenu(subMenuItems: List<SubMenuItem>) {
    BackgroundComponent(Modifier.width(170.dp)) {
        Column(Modifier.padding(3.dp)) {
           subMenuItems.forEach {
               MenuItem(text = it.title, enabled = it.enabled, onClick = it.onClick, hovered = {})
           }
        }
    }
}