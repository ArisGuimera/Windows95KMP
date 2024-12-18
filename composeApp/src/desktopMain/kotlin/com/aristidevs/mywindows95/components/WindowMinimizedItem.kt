package com.aristidevs.mywindows95.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.mywindows95.model.WindowModel
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.ic_folder_open

@Composable
fun WindowMinimizedItem(windowModel: WindowModel, onClick: () -> Unit) {
    Box(Modifier.padding(vertical = 4.dp, horizontal = 2.dp).fillMaxHeight().width(140.dp)
        .clickable { onClick() }) {
        if (windowModel.minimized) {
            BackgroundComponent(modifier = Modifier.fillMaxSize()) {
                Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                    Spacer(Modifier.width(6.dp))
                    Image(
                        painter = painterResource(Res.drawable.ic_folder_open),
                        contentDescription = null,
                        modifier = Modifier.size(19.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(windowModel.title, style = TextStyle(lineHeight = 0.sp))
                }
            }
        } else {
            BackgroundComponent(selected = true, modifier = Modifier.fillMaxSize()) {
                Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {
                    Spacer(Modifier.width(6.dp))
                    Image(
                        painter = painterResource(Res.drawable.ic_folder_open),
                        contentDescription = null,
                        modifier = Modifier.size(19.dp)
                    )
                    Spacer(Modifier.width(6.dp))
                    Text(windowModel.title, style = TextStyle(lineHeight = 0.sp))
                }
            }
        }

    }
}


