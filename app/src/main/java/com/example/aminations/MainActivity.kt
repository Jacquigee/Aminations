package com.example.aminations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aminations.ui.theme.AminationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AminationsTheme {

            }
        }
    }
}

@Preview
@Composable
fun Greeting() {
    var visible by remember {
        mutableStateOf(true)
    }
    val density = LocalDensity.current
    AnimatedVisibility(visible = visible,
        enter = slideInVertically {
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(expandFrom = Alignment.Top)
                + fadeIn(initialAlpha = 0.3f),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
        Text(
            text = "Hello",
            Modifier
                .fillMaxSize()
                .height(200.dp)
        )

    }
}
