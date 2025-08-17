package com.ali_sajjadi.test.bottomSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4
import com.ali_sajjadi.test.ui.theme.h5
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun RecentSearches(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Recent searches",
                style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.colorBrand)
            )
            HorizontalDivider(
                color = LocalCustomColors.current.primaryLine
            )
        }

        val addresses = listOf(
            "0x57E9E78A627BaA30b71793885B952a9006298AF6",
            "0x91b52dD4e97f8a2C478fD25E8C8D3f2D8f5c91A2",
            "0xA832fD3c8929D4bB9dBd93c04dB8A8c8b7C1f39C",
            "0xF38b42d5bE8C32A0b7D7a32e1B77Fec81F53F327",
            "0x0a5E8eF1dC12d1e65fBEE19cF9E7F8b62a7A8fD9"
        )

        var copiedAddress by remember { mutableStateOf<String?>(null) }
        val scope = rememberCoroutineScope()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(addresses) { address ->
                RecentSearchItem(
                    address = address,
                    isCopied = copiedAddress == address,
                    onCopyClick = {
                        copiedAddress = address
                        scope.launch {
                            delay(2000)
                            if (copiedAddress == address) {
                                copiedAddress = null
                            }
                        }
                    }
                )
            }
        }
    }
}


@Composable
fun RecentSearchItem(
    modifier: Modifier = Modifier,
    isCopied: Boolean = false,
    onCopyClick: () -> Unit = {},
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6"
) {

    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_history),
                    contentDescription = "history",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(14.dp)
                )
                Text(
                    text = shortenMiddle(address, 16),
                    style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
                )
                Icon(
                    painter = painterResource(
                        if (isCopied) R.drawable.ic_copy_done else R.drawable.ic_copy
                    ),
                    contentDescription = if (isCopied) "copied" else "copy",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .size(16.dp)
                        .clickable {
                            clipboardManager.setText(AnnotatedString(address))
                            onCopyClick()
                        }
                )


            }
            Row(
                modifier = Modifier
                    .padding(start = 40.dp)
                    .weight(0.4f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_ethereum),
                    contentDescription = "ecosystem",
                    modifier = Modifier
                        .size(20.dp)
                )
                Text(
                    text = "ethereum",
                    style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
                )
            }
        }

        HorizontalDivider(
            color = LocalCustomColors.current.secondaryLine,
            modifier = Modifier.fillMaxWidth(0.6f)
        )
    }
}

@Composable
fun EmptyRecentSearch(modifier: Modifier = Modifier) {

        Text(
            text = "Search History Is Empty !",
            style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
        )


}