package com.bulat.zmtesttask.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bulat.zmtesttask.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CustomProgressBar(
    modifier: Modifier = Modifier,
    progress: Float = 0f,
    max: Int = 10
) {
    var progress by remember { mutableStateOf(progress) }
    val animationScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        animationScope.launch {
            while (progress < 1f) {
                delay(350L)
                progress += 1f / max
            }
        }
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(34.dp)
            .background(
                color = Color(0xFF001B2F),
                shape = CircleShape
            )
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        repeat(max) { index ->
            val isVisible = index < (progress * max).toInt()
            if (isVisible) {
                Box(
                    modifier = Modifier
                        .size(19.dp)
                        //.clip(CircleShape)
                        .paint(painterResource(R.drawable.bubble))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProgressBar() {
    CustomProgressBar()
}