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
import com.aristidevs.mywindows95.components.rightmenu.MenuDivider
import com.aristidevs.mywindows95.model.WindowsMenuCategory
import com.aristidevs.mywindows95.ui.backgroundComponent
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_control
import windows95.composeapp.generated.resources.ic_documents
import windows95.composeapp.generated.resources.ic_exchange
import windows95.composeapp.generated.resources.ic_explorer
import windows95.composeapp.generated.resources.ic_find_computer
import windows95.composeapp.generated.resources.ic_find_document
import windows95.composeapp.generated.resources.ic_find_internet
import windows95.composeapp.generated.resources.ic_find_people
import windows95.composeapp.generated.resources.ic_folder_options
import windows95.composeapp.generated.resources.ic_msdos
import windows95.composeapp.generated.resources.ic_notepad
import windows95.composeapp.generated.resources.ic_printer
import windows95.composeapp.generated.resources.ic_programs

@Composable
fun WindowsBarMenuScreen(showWindowsMenu: Boolean) {
    var subBarMenuPosition by remember { mutableStateOf<Float?>(null) }
    var subBarMenuCategory by remember { mutableStateOf<WindowsMenuCategory?>(null) }

    if (showWindowsMenu) {
        Column {
            Spacer(Modifier.weight(1f))
            Row {
                WindowsMenu { pos, category ->
                    subBarMenuCategory = category
                    subBarMenuPosition = pos
                }
                subBarMenuPosition?.let {
                    BackgroundComponent(Modifier.offset(y = it.dp).width(190.dp)) {
                        Column {
                            when (subBarMenuCategory) {
                                WindowsMenuCategory.Programs -> {
                                    WindowsMenuItem(
                                        "Accesories",
                                        painter = painterResource(Res.drawable.ic_programs),
                                        isSubMenu = true
                                    ) {}

                                    WindowsMenuItem(
                                        "StartUp",
                                        painter = painterResource(Res.drawable.ic_programs),
                                        isSubMenu = true
                                    ) {}

                                    WindowsMenuItem(
                                        "Microsoft Exchange",
                                        painter = painterResource(Res.drawable.ic_exchange),
                                        isSubMenu = true
                                    ) {}

                                    WindowsMenuItem(
                                        "MS-DOS prompt",
                                        painter = painterResource(Res.drawable.ic_msdos),
                                        isSubMenu = true
                                    ) {}

                                    WindowsMenuItem(
                                        "Windows Explorer",
                                        painter = painterResource(Res.drawable.ic_explorer),
                                        isSubMenu = true
                                    ) {}
                                }

                                WindowsMenuCategory.Settings -> {
                                    WindowsMenuItem(
                                        "Control Panel",
                                        painter = painterResource(Res.drawable.ic_control),
                                        isSubMenu = true
                                    ) {}
                                    WindowsMenuItem(
                                        "Printers",
                                        painter = painterResource(Res.drawable.ic_printer),
                                        isSubMenu = true
                                    ) {}
                                    WindowsMenuItem(
                                        "Folder options...",
                                        painter = painterResource(Res.drawable.ic_folder_options),
                                        isSubMenu = true
                                    ) {}
                                }
                                WindowsMenuCategory.Documents -> {
                                    WindowsMenuItem(
                                        "My documents",
                                        painter = painterResource(Res.drawable.ic_documents),
                                        isSubMenu = true
                                    ) {}
                                    MenuDivider()
                                    WindowsMenuItem(
                                        "Readme",
                                        painter = painterResource(Res.drawable.ic_notepad),
                                        isSubMenu = true
                                    ) {}
                                }
                                WindowsMenuCategory.Find -> {
                                    WindowsMenuItem(
                                        "Files or Folders...",
                                        painter = painterResource(Res.drawable.ic_find_document),
                                        isSubMenu = true
                                    ) {}
                                    WindowsMenuItem(
                                        "Computer...",
                                        painter = painterResource(Res.drawable.ic_find_computer),
                                        isSubMenu = true
                                    ) {}
                                    WindowsMenuItem(
                                        "On the Internet...",
                                        painter = painterResource(Res.drawable.ic_find_internet),
                                        isSubMenu = true
                                    ) {}
                                    WindowsMenuItem(
                                        "People",
                                        painter = painterResource(Res.drawable.ic_find_people),
                                        isSubMenu = true
                                    ) {}
                                }
                                null -> {}
                            }
                        }
                    }
                }
            }
        }
    }
}