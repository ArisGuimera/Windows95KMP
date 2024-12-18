package com.aristidevs.mywindows95.model

import androidx.compose.ui.geometry.Offset
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class FolderModel(
    val id:Int,
    val name:String = "New folder",
    val position:Offset,
    val selected:Boolean = false,
    val createdDate:Instant = Clock.System.now()
)