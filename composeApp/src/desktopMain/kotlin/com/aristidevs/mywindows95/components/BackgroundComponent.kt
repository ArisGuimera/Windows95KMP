package com.aristidevs.mywindows95.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.aristidevs.mywindows95.ui.backgroundComponent

@Composable
fun BackgroundComponent(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    content: @Composable () -> Unit
) {
    Box(modifier.background(backgroundComponent).drawBehind {
        val strokeWidth = 1.5f
        val spacing = 1.5f
        val width = size.width
        val height = size.height

        //Lateral izquierdo 1 linea
        drawLine(
            color = if(selected) Color.Black else Color.White,
            start = Offset(0f, 0f),
            end = Offset(0f, height),
            strokeWidth = strokeWidth
        )

        //Lateral izquierdo 2 linea
        drawLine(
            color = if(selected) Color.DarkGray else Color.White,
            start = Offset(spacing, 0f),
            end = Offset(spacing, height),
            strokeWidth = strokeWidth
        )

        // superior 1 linea
        drawLine(
            color = if(selected) Color.Black else Color.White,
            start = Offset(0f, 0f),
            end = Offset(width, 0f),
            strokeWidth = strokeWidth
        )

        // superior 2 linea
        drawLine(
            color = if(selected) Color.DarkGray else Color.White,
            start = Offset(0f, spacing),
            end = Offset(width, spacing),
            strokeWidth = strokeWidth
        )


        //Lateral derecho 1 linea
        drawLine(
            color = if(selected) Color.White else Color.Black,
            start = Offset(width, 0f),
            end = Offset(width, height),
            strokeWidth = strokeWidth
        )

        //Lateral derecho 2 linea
        drawLine(
            color = if(selected) Color.White else Color.DarkGray,
            start = Offset(width - spacing, 0f),
            end = Offset(width - spacing, height),
            strokeWidth = strokeWidth
        )


        //Inferior 1 linea
        drawLine(
            color = if(selected) Color.White else Color.Black,
            start = Offset(0f, height),
            end = Offset(width, height),
            strokeWidth = strokeWidth
        )

        //Inferior 2 linea
        drawLine(
            color = if(selected) Color.White else Color.DarkGray,
            start = Offset(0f, height - spacing),
            end = Offset(width, height - spacing),
            strokeWidth = strokeWidth
        )
    }) {
        content()
    }
}