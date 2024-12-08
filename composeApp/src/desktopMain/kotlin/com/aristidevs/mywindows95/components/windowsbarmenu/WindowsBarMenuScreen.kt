package com.aristidevs.mywindows95.components.windowsbarmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.components.BackgroundComponent
import com.aristidevs.mywindows95.ui.backgroundComponent
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_programs

@Composable
fun WindowsBarMenuScreen(showWindowsMenu: Boolean) {
    var subBarMenuPosition by remember { mutableStateOf<Float?>(null) }

    if (showWindowsMenu) {
        Column {
            Spacer(Modifier.weight(1f))
            Row {
                WindowsMenu { subBarMenuPosition = it }
                subBarMenuPosition?.let {
                    BackgroundComponent(Modifier.offset(y = it.dp).width(150.dp)){
                        Column {
                            WindowsMenuItem(
                                text = "Accesories",
                                painter = painterResource(Res.drawable.ic_programs),
                                isSubMenu = true
                            ){}
                            WindowsMenuItem(
                                text = "Accesories",
                                painter = painterResource(Res.drawable.ic_programs),
                                isSubMenu = true
                            ){}
                            WindowsMenuItem(
                                text = "Accesories",
                                painter = painterResource(Res.drawable.ic_programs),
                                isSubMenu = true
                            ){}
                            WindowsMenuItem(
                                text = "Accesories",
                                painter = painterResource(Res.drawable.ic_programs),
                                isSubMenu = true
                            ){}
                        }
                    }
                }
            }
        }
    }
}