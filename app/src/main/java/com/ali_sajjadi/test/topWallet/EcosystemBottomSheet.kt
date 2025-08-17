package com.ali_sajjadi.test.topWallet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h6

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcosystemBottomSheet(
    modifier: Modifier = Modifier,
    ecosystems: List<String> = listOf("Ethereum", "Polygon", "BSC"),
    selected: String? = null,
    onSelect: (String?) -> Unit = {},
    onDismiss: () -> Unit = {}
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismiss,
        containerColor = LocalCustomColors.current.bottomSheet,
        shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(bottom = 30.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sort by ecosystem",
                style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                item {
                    EcosystemItem(
                        ecosystemIcon = null,
                        ecosystemName = "All Ecosystem",
                        isSelected = selected == null,
                        onClick = { onSelect(null) }
                    )
                }

                items(ecosystems) { eco ->
                    EcosystemItem(
                        ecosystemIcon = R.drawable.ic_ethereum,
                        ecosystemName = eco,
                        isSelected = eco == selected,
                        onClick = { onSelect(eco) }
                    )
                }
            }
        }
    }
}


@Composable
fun EcosystemItem(
    modifier: Modifier = Modifier,
    ecosystemIcon: Any? = R.drawable.ic_ethereum,
    ecosystemName: String = "Ethereum",
    isSelected: Boolean = false,
    onClick: () -> Unit = {}
) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            if (ecosystemIcon != null) {
                AsyncImage(
                    model = ecosystemIcon,
                    contentDescription = "ecosystem icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(20.dp),
                    placeholder = null,
                    error = null
                )
            }

            Text(
                text = ecosystemName,
                style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
            )
        }

        if (isSelected) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tick),
                contentDescription = "tick icon",
                tint = LocalCustomColors.current.colorBrand,
                modifier = Modifier.size(20.dp)
            )
        }

    }

}
