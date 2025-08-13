package com.ali_sajjadi.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit,
    onSearchBarClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(LocalCustomColors.current.background)
            .padding(horizontal = 16.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(
            modifier = modifier
                .size(30.dp)
                .clickable { onMenuClick() },
            painter = painterResource(R.drawable.ic_menu),
            contentDescription = "menu_icon",
            tint = LocalCustomColors.current.icon
        )

        Text(
            text = "CRYPTO",
            style = MaterialTheme.typography.headlineMedium.copy(color = Color(0xFFDE0A0A))
        )

        CustomButton(
            modifier = Modifier
                .height(30.dp)
                .width(30.dp),
            radius = 8.dp,
            onClick = { onSearchBarClick() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_plus),
                contentDescription = "search_icon",
                modifier = modifier
                    .size(20.dp),
                tint = Color.White
            )
        }
    }
}
