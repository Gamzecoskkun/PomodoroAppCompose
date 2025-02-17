package com.example.pomodoroappcompose.components

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pomodoroappcompose.R

@Composable
fun StopButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        SvgIcon(
            svgResourceId = R.drawable.ic_stop,
            size = dimensionResource(R.dimen.btn_size)

        )
    }
}

@Composable
fun ResumeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        SvgIcon(
            svgResourceId = R.drawable.ic_play,
            size = dimensionResource(R.dimen.btn_size)
        )
    }
}

@Composable
fun PauseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        SvgIcon(
            svgResourceId = R.drawable.ic_pause,
            size = dimensionResource(R.dimen.btn_size))
    }
}

@Preview(showBackground = true)
@Composable
fun StopButtonPreview() {
    StopButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun ResumeButtonPreview() {
    ResumeButton(onClick = {})
}

@Preview(showBackground = true)
@Composable
fun PauseButtonPreview() {
    PauseButton(onClick = {})
}
