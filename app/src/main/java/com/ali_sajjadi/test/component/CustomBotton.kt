package com.ali_sajjadi.test.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.ui.theme.LocalCustomColors

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    radius: Dp= 16.dp,
    isSelected: Boolean = false,
    backgroundBrush: Brush = LocalCustomColors.current.primaryButton,
    background: Color = Color.Transparent,
    strokeColor: Color = Color.Transparent,
    strokeWidth: Dp = 2.dp,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {

    Button(
        modifier = modifier
            .then(
                if (isSelected) {
                    Modifier
                        .background(
                            color = background,
                            shape =RoundedCornerShape(radius)
                        )
                        .border(
                            width = strokeWidth,
                            color = strokeColor,
                            shape = RoundedCornerShape(radius)
                        )
                } else {
                    Modifier.background(backgroundBrush, shape = RoundedCornerShape(radius))
                }
            ),

        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(radius),
        contentPadding = PaddingValues(0.dp),
        onClick = onClick,
    ) {
        content()
    }
}




