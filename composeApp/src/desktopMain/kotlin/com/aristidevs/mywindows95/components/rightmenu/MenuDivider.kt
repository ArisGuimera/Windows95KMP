package com.aristidevs.mywindows95.components.rightmenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuDivider(){
    Column(Modifier.padding(horizontal = 2.dp)) {
        Divider(color = Color.Black.copy(0.5f), thickness = 2.dp)
        Divider(color = Color.White, thickness = 2.dp)
    }
}