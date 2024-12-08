package com.aristidevs.mywindows95.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.layout

fun Modifier.rotateVertically(clockwise: Boolean = true): Modifier {

    val rotate = rotate(if (clockwise) 90f else -90f)

    val modifiedView = layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        layout(placeable.height, placeable.width) {
            placeable.place(
                x = -(placeable.width / 2 - placeable.height / 2),
                y = -(placeable.height / 2 - placeable.width / 2)
            )
        }
    }

    return rotate then modifiedView
}

@Composable
fun Modifier.clickableWithoutRipple(onClick: () -> Unit): Modifier {
    return this.clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}