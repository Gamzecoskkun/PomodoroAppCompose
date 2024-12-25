package com.example.pomodoroappcompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RemainingTime(
    canvas: Dp = 300.dp,
    color: Color = MaterialTheme.colorScheme.primary,
    value: Int = 23,
    maxValue: Int = 60,
) {
    var percentage = 1f
    if (value <= maxValue) {
        percentage = (value.toFloat() / maxValue.toFloat())
    }
    val sweepAngle by animateFloatAsState(
        targetValue = (percentage * 360),
        animationSpec = tween(100), label = ""
    )

    Column(
        modifier = Modifier
            .size(canvas)
            .drawBehind {
                val component = size / 1.25f

                foregroundIndicator(
                    component = component,
                    sweepAngle = sweepAngle,
                    color = color
                )
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { }


}

fun DrawScope.foregroundIndicator(
    component: androidx.compose.ui.geometry.Size,
    sweepAngle: Float,
    color: Color,
) {
    drawArc(
        size = component,
        color = color,
        startAngle = 270f,
        sweepAngle = sweepAngle,
        useCenter = true,

        topLeft = Offset(
            x = (size.width - component.width) / 2f,
            y = (size.height - component.height) / 2f
        )
    )
}

@Composable
@Preview(showBackground = true,widthDp = 400, heightDp = 400)
fun PercentageCirclePreview(){
    RemainingTime(
        canvas = 300.dp,
        color = MaterialTheme.colorScheme.primary,
        value = 23,
        maxValue = 60
    )
}

