package com.aristidevs.mywindows95.windows95

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aristidevs.mywindows95.components.WindowsBar
import com.aristidevs.mywindows95.components.WindowsButton

@Composable
fun Windows95Screen(){
    Column {
        Box(Modifier.fillMaxWidth().weight(1f), contentAlignment = Alignment.Center){

        }
        WindowsBar()
    }
}