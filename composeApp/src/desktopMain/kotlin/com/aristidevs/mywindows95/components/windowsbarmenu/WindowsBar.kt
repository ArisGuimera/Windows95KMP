package com.aristidevs.mywindows95.components.windowsbarmenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aristidevs.mywindows95.components.WindowMinimizedItem
import com.aristidevs.mywindows95.components.WindowsButton
import com.aristidevs.mywindows95.model.WindowModel
import com.aristidevs.mywindows95.ui.backgroundComponent
import org.jetbrains.compose.resources.painterResource
import windows95.composeapp.generated.resources.Res
import windows95.composeapp.generated.resources.winlogo

@Composable
fun WindowsBar(
    windows: List<WindowModel>,
    onClickMinimizedWindow: (WindowModel) -> Unit,
    onWindowsButtonSelected: () -> Unit
) {
    Column {
        Box(Modifier.height(1.dp).fillMaxWidth().background(Color.White))
        Row(
            modifier = Modifier.height(40.dp).fillMaxWidth().background(backgroundComponent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            WindowsButton(Modifier.padding(start = 8.dp).height(36.dp).width(95.dp),
                onClick = { onWindowsButtonSelected() }) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(36.dp),
                        painter = painterResource(Res.drawable.winlogo),
                        contentDescription = "Windows Logo",
                        contentScale = ContentScale.FillWidth
                    )
                    Spacer(Modifier.width(4.dp))
                    Text("Start", fontSize = 18.sp, modifier = Modifier.padding(bottom = 4.dp))
                }
            }
            Row(modifier = Modifier.weight(1f)) {
                windows.forEach { window ->
                    key(window.id) {
                        WindowMinimizedItem(window) { onClickMinimizedWindow(window) }
                    }
                }
            }
            InformationBar()
        }
    }
}