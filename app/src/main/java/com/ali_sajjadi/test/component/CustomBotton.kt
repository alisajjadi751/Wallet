package com.ali_sajjadi.test.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.ui.theme.LocalCustomColors

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    radius: Dp = 16.dp,
    isSelected: Boolean = false,
    backgroundBrush: Brush = LocalCustomColors.current.primaryButton,
    background: Color = Color.Transparent,
    strokeColor: Color = LocalCustomColors.current.outlinedButtonBrand,
    strokeWidth: Dp = 2.dp,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {

    Button(
        modifier = modifier,
        shape = RoundedCornerShape(radius),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        contentPadding = PaddingValues(0.dp),
        onClick = onClick,
    ) {
        Box(
            modifier = if (isSelected) {
                modifier
                    .background(
                        color = background,
                        shape = RoundedCornerShape(radius)
                    )
                    .border(
                        width = strokeWidth,
                        color = strokeColor,
                        shape = RoundedCornerShape(radius)
                    )
            } else {
                modifier.background(backgroundBrush, shape = RoundedCornerShape(radius))
            },
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}




