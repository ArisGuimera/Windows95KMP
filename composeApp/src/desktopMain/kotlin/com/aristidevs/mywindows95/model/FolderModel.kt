package com.aristidevs.mywindows95.model

import androidx.compose.ui.geometry.Offset
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import org.jetbrains.compose.resources.DrawableResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_documents
import windows95.composeapp.generated.resources.ic_folder

data class FolderModel(
    val id:Int,
    val name:String = "New folder",
    val position:Offset,
    val selected:Boolean = false,
    val createdDate:Instant = Clock.System.now(),
    val icon:DrawableResource = Res.drawable.ic_folder
)