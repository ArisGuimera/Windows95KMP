package com.aristidevs.mywindows95.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isSecondaryPressed
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.IntOffset

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

@Composable
fun Modifier.patternBackground(): Modifier {
    return this.then(Modifier.drawWithContent {
        drawPatternBackground(this)
        drawContent()
    })
}

private fun drawPatternBackground(scope: DrawScope) {
    val paintLightColor = Paint().apply {
        color = Color.White
    }

    scope.drawIntoCanvas { canvas ->
        val size = 1.3f

        for (y in 0 until scope.size.height.toInt() step size.toInt() * 2) {
            for (x in 0 until scope.size.width.toInt() step size.toInt() * 2) {
                canvas.drawRect(Rect(x.toFloat(), y.toFloat(), size + x, size + y), paintLightColor)
            }
        }
    }

}

fun Modifier.onRightClick(onClickPosition: (IntOffset) -> Unit): Modifier {
    return this.pointerInput(Unit) {
        awaitPointerEventScope {
            while (true) {
                val event = awaitPointerEvent()
                if (event.type == PointerEventType.Press && event.buttons.isSecondaryPressed) {
                    onClickPosition(
                        IntOffset(
                            x = event.changes.first().position.x.toInt(),
                            y = event.changes.first().position.y.toInt()
                        )
                    )
                }
            }
        }
    }
}










