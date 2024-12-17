package com.aristidevs.mywindows95.model

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp

data class WindowModel(
    val id:Int,
    val title:String,
    val position:Offset,
    val minimized:Boolean = false,
    val expanded:Boolean = false,
    val selected:Boolean = false,
    val size:DpSize = DpSize(400.dp, 400.dp)
)