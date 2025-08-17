package com.ali_sajjadi.test.bottomSheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h8

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteBottomSheet(listItem: List<String> = emptyList(),
                        value: String = "",
                        text: String = "",
                        onSelect: (String) -> Unit = {},
                        onDismiss: () -> Unit = {}) {

    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
        containerColor = LocalCustomColors.current.bottomSheet,
        shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)

    ) {

        Column(modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(
                text = text,
                style = MaterialTheme.typography.h5.copy(fontSize = 16.sp, fontWeight = FontWeight.Medium
                    , color = LocalCustomColors.current.primaryText)
            )

            LazyColumn {

                items(listItem) { item ->
                    ItemSort(item = item, isSelect = item == value) { onSelect(item)}
                }

            }

        }

    }

}

@Composable
fun ItemSort(modifier: Modifier = Modifier,
             item: String = "Balance",
             isSelect: Boolean = false,
             onClickItem: () -> Unit = {}) {

    Row(modifier = modifier.fillMaxWidth()
        .clickable(true){onClickItem()}
        .padding(vertical = 11.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        Text(
            text = item, style = MaterialTheme.typography.h8.copy(fontSize = 14.sp,
                fontWeight = FontWeight.Medium, color = LocalCustomColors.current.primaryText)
        )

        if (isSelect) {

            Image(modifier = Modifier.size(21.dp),
                painter = painterResource(R.drawable.ic_tick),
                contentDescription = null)

        }

    }

}