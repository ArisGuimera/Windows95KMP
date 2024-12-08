package com.aristidevs.mywindows95.components.windowsbarmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.ui.backgroundComponent
import com.aristidevs.mywindows95.ui.windowsBlue
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_arrow

@Composable
fun WindowsMenuItem(
    text: String,
    painter: Painter,
    expandable: Boolean = false,
    isSubMenu: Boolean = false,
    showSubMenu: (Float?) -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val backgroundColor = if (isHovered) windowsBlue else backgroundComponent
    val accentColor = if (isHovered) Color.White else Color.Black

    var globalHeightPosition by remember { mutableStateOf<Float?>(null) }

    LaunchedEffect(isHovered) {
        when {
            isHovered && expandable -> {
                showSubMenu(globalHeightPosition)
            }

            expandable -> {}
            isHovered -> {
                showSubMenu(null)
            }
        }
    }

    Row(
        modifier = Modifier.hoverable(interactionSource).onGloballyPositioned { coordinates ->
            globalHeightPosition = coordinates.positionInParent().y
        }.padding(4.dp).fillMaxWidth().background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(6.dp))
        Image(
            modifier = Modifier.size(if (isSubMenu) 20.dp else 40.dp),
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
        Spacer(Modifier.width(6.dp))
        Text(text = text, color = accentColor)
        if (expandable) {
            Spacer(Modifier.weight(1f))
            Icon(
                modifier = Modifier.padding(horizontal = 4.dp).size(12.dp),
                painter = painterResource(Res.drawable.ic_arrow),
                tint = accentColor,
                contentDescription = "arrow"
            )
        }
    }

}