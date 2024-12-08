package com.aristidevs.mywindows95.windows95

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import com.aristidevs.mywindows95.components.DraggableFolder
import com.aristidevs.mywindows95.components.windowsbarmenu.WindowsBar
import com.aristidevs.mywindows95.components.windowsbarmenu.WindowsBarMenuScreen
import com.aristidevs.mywindows95.extensions.clickableWithoutRipple
import com.aristidevs.mywindows95.model.FolderModel

@Composable
fun Windows95Screen() {
    var showWindowsMenu by remember { mutableStateOf(false) }
    val fakeFolder = FolderModel(0, "AristiDevs", Offset(x = 0f, y = 0f))
    var folders by remember { mutableStateOf(listOf<FolderModel>(fakeFolder)) }

    Column {
        Box(Modifier.fillMaxWidth().weight(1f).clickableWithoutRipple {
            showWindowsMenu = false
            folders = clearFolders(folders)
        }) {
            folders.forEach { folder ->
                DraggableFolder(folder, onMove = { newPosition ->
                    folders = folders.map {
                        if (it.id == folder.id) it.copy(position = newPosition) else it
                    }
                }, onTapFolder = { id ->
                    folders = folders.map { if (id == it.id) it.copy(selected = true) else it }
                }, onRename = { newName ->
                    folders = folders.map {
                        if (it.id == folder.id) it.copy(name = newName) else it
                    }
                }, onDoubleTapFolder = {})
            }
            WindowsBarMenuScreen(showWindowsMenu)
        }
        WindowsBar { showWindowsMenu = !showWindowsMenu }
    }
}

fun clearFolders(folders: List<FolderModel>): List<FolderModel> {
    val clearFolders = folders.map { it.copy(selected = false) }
    return clearFolders
}
