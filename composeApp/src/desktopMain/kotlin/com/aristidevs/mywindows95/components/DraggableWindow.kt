package com.aristidevs.mywindows95.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.onDrag
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.model.WindowModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DraggableWindow(
    windowModel: WindowModel,
    onMove: (Offset) -> Unit,
    onClose: () -> Unit,
    onMinimize: () -> Unit,
    onExpand: () -> Unit
) {

    var currentOffSet by remember { mutableStateOf(windowModel.position) }
    val density = LocalDensity.current

    var prevPosition by remember { mutableStateOf(windowModel.position) }

    BoxWithConstraints {
        val containerWidthPx = with(density) { maxWidth.toPx() }
        val containerHeightPx = with(density) { maxHeight.toPx() }

        val windowWidthPx =
            if (windowModel.expanded) containerWidthPx else with(density) { windowModel.size.width.toPx() }
        val windowHeightPx =
            if (windowModel.expanded) containerHeightPx else with(density) { windowModel.size.height.toPx() }

        LaunchedEffect(windowModel.expanded) {
            currentOffSet = if (windowModel.expanded) {
                Offset(0f, 0f)
            } else {
                prevPosition
            }
            onMove(currentOffSet)
        }

        BackgroundComponent(Modifier.then(
            if (windowModel.expanded) Modifier.fillMaxSize() else Modifier.size(
                windowModel.size
            )
        ).offset {
            IntOffset(currentOffSet.x.toInt(), currentOffSet.y.toInt())
        }.onDrag(matcher = PointerMatcher.mouse(PointerButton.Primary), onDrag = { offset ->
            if (!windowModel.expanded) {
                val newX =
                    (currentOffSet.x + offset.x).coerceIn(0f, containerWidthPx - windowWidthPx)
                val newY = (currentOffSet.y + offset.y).coerceIn(
                    0f, containerHeightPx - windowHeightPx
                )
                val newOffSet = Offset(newX, newY)
                currentOffSet = newOffSet
                prevPosition = newOffSet
                onMove(newOffSet)
            }
        }

        )) {
            Column {

                WindowToolbar(Modifier.padding(4.dp),
                    windowModel.title,
                    windowModel.selected,
                    onMinimize = { onMinimize() },
                    onExpand = { onExpand() },
                    onClose = { onClose() })
                Row {
                    Spacer(Modifier.width(10.dp))
                    Text("File")
                    Spacer(Modifier.width(10.dp))
                    Text("Edit")
                    Spacer(Modifier.width(10.dp))
                    Text("View")
                    Spacer(Modifier.width(10.dp))
                    Text("Help")
                }
                BackgroundComponent(
                    Modifier.fillMaxSize()
                        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 4.dp),
                    selected = true
                ) {
                    Box(Modifier.fillMaxSize().background(Color.White))
                }
            }
        }
    }
}