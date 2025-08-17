package com.ali_sajjadi.test.searchHisrtory

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4
import com.ali_sajjadi.test.ui.theme.h4
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h6

@Composable
fun SearchHistoryScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColors.current.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Recent searches",
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.secondaryText)
                )

                Text(
                    text = "clear all",
                    style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.colorBrand),
                    modifier = Modifier
                        .clickable {

                        }
                )


            }

            HorizontalDivider(
                color = LocalCustomColors.current.primaryLine,
                modifier = Modifier.fillMaxWidth(0.9f)
            )
        }


        SearchHistoryItem()


    }

}

@Composable
fun SearchHistoryItem(
    modifier: Modifier = Modifier,
    isCopied: Boolean = false,
    onCopyClick: () -> Unit = {},
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6",
    date: String = "2025/04/03"
) {

    val clipboardManager = LocalClipboardManager.current
    Column (
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_history),
                contentDescription = "history",
                tint = Color.Unspecified,
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = date,
                style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
            )
        }

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

                    Text(
                        text = shortenMiddle(address, 16),
                        style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
                    )


                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = "history",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(16.dp)
                        )


                    Icon(
                        painter = painterResource(
                            if (isCopied) R.drawable.ic_copy_done else R.drawable.ic_copy
                        ),
                        contentDescription = if (isCopied) "copied" else "copy",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(22.dp)
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
                        tint = Color.Unspecified,
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

}
