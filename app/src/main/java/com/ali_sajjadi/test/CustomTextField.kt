package com.ali_sajjadi.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4

@Preview(showBackground = true)
@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    background: Color =LocalCustomColors.current.textFieldSearch,
    hint: String = "wallet address",
    value: String = "",
    onValueChange: (String) -> Unit = {},
    onClickClear: () -> Unit = {}
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(background),
        singleLine = true,
        cursorBrush = SolidColor(LocalCustomColors.current.cursor),
        textStyle = MaterialTheme.typography.body4.copy(
            color = LocalCustomColors.current.primaryText
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.body3.copy(
                                color = LocalCustomColors.current.hintTextFieldSearch
                            )
                        )
                    }
                    innerTextField()
                }
                if (value.isNotBlank())
                Icon(
                    painter = painterResource(R.drawable.ic_clear),
                    contentDescription = "clear",
                    modifier = Modifier
                        .size(15.dp)
                        .clickable { onClickClear() },
                    tint = Color.Unspecified
                )
            }
        }
    )
}

