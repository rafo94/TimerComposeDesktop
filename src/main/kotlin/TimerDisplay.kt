import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TimerDisplay(
    formattedTime: String,
    onStartClick: () -> Unit,
    onPauseClick: () -> Unit,
    onResetClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(resourcePath = "timestopwatch.png"),
            contentDescription = "stopwatch",
            modifier = Modifier.width(200.dp).height(200.dp)
        )

        Text(
            text = formattedTime,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
        Spacer(Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = onStartClick) { Text("Start") }
            Spacer(Modifier.width(16.dp))
            Button(onClick = onPauseClick) { Text("Pause") }
            Spacer(Modifier.width(16.dp))
            Button(onClick = onResetClick) { Text("Reset") }
        }
    }
}