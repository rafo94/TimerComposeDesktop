// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
                .background(color = if (isSystemInDarkTheme()) Color.DarkGray else Color.White)
        ) {
            val stopWatch = remember { StopWatch() }
            TimerDisplay(
                formattedTime = stopWatch.formattedTime,
                onStartClick = stopWatch::start,
                onPauseClick = stopWatch::pause,
                onResetClick = stopWatch::reset
            )
        }
    }
}

fun main() = application {
    val windowState = rememberWindowState()
    windowState.size = DpSize(392.dp, 642.dp)
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "Stop Watch",
        icon = painterResource(resourcePath = "timestopwatch.png"),
        resizable = false
    ) {
        App()
    }
}
