package com.ali_sajjadi.test

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ali_sajjadi.test.bottomSheet.FavoriteBottomSheet
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.TestTheme
import com.ali_sajjadi.test.ui.theme.blueAddress
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h8
import com.ali_sajjadi.test.ui.theme.h9
import com.ali_sajjadi.test.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//@Composable
//@Preview("FavoriteScreen", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//fun LoginScreenPreview() {
//    TestTheme {
//        FavoriteScreen()
//    }
//}

@Composable
fun FavoriteScreen(modifier: Modifier = Modifier) {

    val isEmptyList by remember { mutableStateOf(false) }
    var isShowBottomSheet by remember { mutableStateOf(false) }
    var itemSortSelected by remember { mutableStateOf("Balance") }

    Box(modifier = modifier.fillMaxSize()
        .background(LocalCustomColors.current.background),
        contentAlignment = Alignment.Center) {

        if (isEmptyList) {

            EmptyList(modifier = Modifier.align(Alignment.Center))

        } else {

            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp).padding(top = 8.dp)
            ) {

                Box(
                    modifier = Modifier.height(50.dp).align(Alignment.Start)
                        .clickable(true) { isShowBottomSheet = true },
                    contentAlignment = Alignment.Center
                ) {

                    CustomButton(
                        modifier = Modifier
                            .size(70.dp, 30.dp)
                            , onClick = {isShowBottomSheet = true},
                        secondaryButton = true,
                        radius = 12.dp,
                        strokeColor = LocalCustomColors.current.textFieldSearch2,
                        background = LocalCustomColors.current.textFieldSearch2
                    ) {

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Sort",
                                color = LocalCustomColors.current.primaryText,
                                style = MaterialTheme.typography.h9.copy(
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            )

                            Image(
                                painter = painterResource(R.drawable.ic_sort),
                                contentDescription = null
                            )
                        }
                    }
                }

                var copiedAddress by remember { mutableStateOf<String?>(null) }
                val scope = rememberCoroutineScope()

                val addresses = listOf(
                    "0x57E9E78A627BaA30b71793885B952a9006298AF6",
                    "0x91b52dD4e97f8a2C478fD25E8C8D3f2D8f5c91A2",
                    "0xA832fD3c8929D4bB9dBd93c04dB8A8c8b7C1f39C",
                    "0xF38b42d5bE8C32A0b7D7a32e1B77Fec81F53F327",
                    "0x0a5E8eF1dC12d1e65fBEE19cF9E7F8b62a7A8fD9"
                )

                LazyColumn(modifier = Modifier.padding(top = 20.dp)) {

                    items(addresses) { address ->

                        ItemFavorite(
                            isCopied = copiedAddress == address,
                            onCopyClick = {
                                copiedAddress = address
                                scope.launch {
                                    delay(2000)
                                    if (copiedAddress == address) {
                                        copiedAddress = null
                                    }
                                }
                            }, onFavoriteClick = {

                            })

                    }

                }

            }
        }

    }

    if (isShowBottomSheet) {

        FavoriteBottomSheet(listItem = listOf("default (Date)","Balance"), value = itemSortSelected,
            text = "Sort by", onSelect = { item ->
                itemSortSelected = item
                isShowBottomSheet = false
            }, onDismiss = {
                isShowBottomSheet = false
            })

    }

}

@Composable
fun ItemFavorite(modifier: Modifier = Modifier,
                 isCopied: Boolean = false,
                 onCopyClick: () -> Unit = {},
                 onFavoriteClick: () -> Unit = {},
                 address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6",
                 iconChain: String = "", isFavorite: Boolean = false,
                 balance: String = "1890343344", nameChain: String = "ethereum") {

    val clipboardManager = LocalClipboardManager.current

    Column(modifier = modifier.padding(top = 22.dp)) {

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween) {

            Row(modifier = Modifier.weight(0.7f)) {

                AsyncImage(modifier = Modifier.size(30.dp).
                align(Alignment.CenterVertically),
                    model = R.drawable.img_wallet,
                    contentScale = ContentScale.Crop, contentDescription = null)

                Column(modifier = Modifier.padding(start = 6.dp)
                    .align(Alignment.CenterVertically),
                    verticalArrangement = Arrangement.spacedBy(6.dp)) {

                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween) {

                        Row {

                            Text(
                                text = shortenMiddle(address, 12),
                                style = MaterialTheme.typography.h8.copy(fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium, color = blueAddress
                                )
                            )

                            Text(text = " ($nameChain) ", style = MaterialTheme.typography.h8.copy(
                                fontSize = 14.sp, fontWeight = FontWeight.Medium,
                                color = LocalCustomColors.current.primaryText
                            ))

                        }

                        Icon(
                            painter = painterResource(
                                if (isCopied) R.drawable.ic_copy_done else R.drawable.ic_copy
                            ),
                            contentDescription = if (isCopied) "copied" else "copy",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 6.dp)
                                .size(22.dp)
                                .clickable {
                                    clipboardManager.setText(AnnotatedString(address))
                                    onCopyClick()
                                }
                        )

                    }

                    Text(text = "$ " + Constants.separator.format(balance.toInt()).toString(),
                        style = MaterialTheme.typography.h8.copy(fontSize = 14.sp,
                            fontWeight = FontWeight.Medium, color = LocalCustomColors.current.primaryText))

                }

            }

            Box(modifier = Modifier.weight(0.3f),
                contentAlignment = Alignment.CenterEnd) {
                Image(modifier = Modifier.size(24.dp)
                    .clickable(true){onFavoriteClick()},
                    painter = painterResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_outlinstar),
                    contentDescription = null)
            }

        }

        HorizontalDivider(modifier = Modifier.padding(top = 20.dp)
            .width(200.dp).align(Alignment.CenterHorizontally),
            thickness = 1.dp, LocalCustomColors.current.secondaryLine)

    }

}

@Composable
fun EmptyList(modifier: Modifier = Modifier, text: String = "No Favorite Yet !") {

    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = text, style = MaterialTheme.typography.h5.copy(fontSize = 24.sp,
            fontWeight = FontWeight.Medium, color = LocalCustomColors.current.primaryLine))

        Image(modifier = Modifier.size(64.dp),
            painter = painterResource(R.drawable.ic_empty_list),
            contentDescription = null)

    }

}