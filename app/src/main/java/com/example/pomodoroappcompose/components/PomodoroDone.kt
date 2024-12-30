package com.example.pomodoroappcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pomodoroappcompose.R

@Composable
fun PomodoroDone(
    modifier: Modifier,
    done: Int = 1,
) {
    LazyRow(
        modifier = modifier
    ) {
        for (i in 0 until 4) {
            item(key = i) {
                Box(
                    modifier = modifier
                        .size(dimensionResource(id = R.dimen.pomodoro_done_dot_size))
                        .clip(CircleShape)
                        .background(if(done>=i+1) Color.Red else Color.Red.copy(0.5f) )
                )
                if (i!=3)
                    Spacer(
                        modifier=modifier.padding(
                            horizontal = dimensionResource(id=R.dimen.pomodoro_done_dot_spacing)
                        )
                    )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PomodoroDonePreview(){
    PomodoroDone(modifier = Modifier, done = 1)
}