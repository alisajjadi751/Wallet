package com.ali_sajjadi.test.walletInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
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
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h6
import com.ali_sajjadi.test.ui.theme.h9
import com.ali_sajjadi.test.utils.Constants.separator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun WalletInfoScreen(
    modifier: Modifier = Modifier,
    address: String = "0x1234567890123456789012345678901234567890",
    balance: Int = 985456773
) {

    var isSelected by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }
    var isCopied by remember { mutableStateOf(false) }
    var showInfoSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColors.current.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Wallet Info",
                style = MaterialTheme.typography.h9.copy(color = LocalCustomColors.current.primaryText)
            )

            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = LocalCustomColors.current.primaryText,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .clickable { }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_wallet),
                    contentDescription = "Wallet image",
                    modifier = Modifier
                        .size(40.dp)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Text(
                            text = shortenMiddle(text = address, visibleChars = 8),
                            style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
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
                                    isCopied = true
                                    scope.launch {
                                        delay(2000)
                                        isCopied = false
                                    }

                                }
                        )

                    }

                    Text(
                        text = "$ " + separator.format(balance),
                        style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                    )
                }
            }

            CustomButton(
                secondaryButton = isSelected,
                modifier = Modifier
                    .size(width = 70.dp, height = 30.dp),
                radius = 10.dp,
                onClick = {
                    isSelected = !isSelected
                }

            ) {
                Text(
                    text = if (isSelected) "Untrack" else "Track",
                    style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomButton(
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                secondaryButton = true,
                background = LocalCustomColors.current.secondaryButton,
                strokeColor = LocalCustomColors.current.outlinedButton,
                strokeWidth = 1.dp,
                onClick = {
                    isFavorite = !isFavorite
                },
                content = {
                    Text(
                        text = if (isFavorite) "Remove from favorites" else "Add to favorites",
                        style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
                    )
                }
            )

            CustomButton(
                modifier = Modifier
                    .height(40.dp)
                    .weight(1f),
                secondaryButton = true,
                background = LocalCustomColors.current.secondaryButton,
                strokeColor = LocalCustomColors.current.outlinedButton,
                strokeWidth = 1.dp,
                onClick = {

                    showInfoSheet = true
                    /*TODO()*/
                },
                content = {
                    Text(
                        text = "Info",
                        style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
                    )
                }
            )
        }

        AssetsTransactionsTabView()

    }
    if (showInfoSheet){
        InfoBottomSheet(
            onDismiss = { showInfoSheet = false }
        )
    }


}

@Composable
fun AssetsTransactionsTabView() {
    val tabs = listOf("Assets", "Transactions")
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { tabs.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {

        TabRow(
            selectedTabIndex = pagerState.currentPage,
            modifier = Modifier.fillMaxWidth(),
            containerColor = Color.Transparent,
            contentColor = Color.Black,
            divider = {
                HorizontalDivider(
                    color = LocalCustomColors.current.secondaryLine
                )
            },
            indicator = { tabPositions ->

                TabRowDefaults.PrimaryIndicator(
                    Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
                    width = 50.dp,
                    color = LocalCustomColors.current.colorBrand
                )
            },


            ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = pagerState.currentPage == index,
                    selectedContentColor = LocalCustomColors.current.colorBrand,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    modifier = Modifier.padding(0.dp),
                    text = {
                        Text(
                            text = title,
                            style = if (pagerState.currentPage == index) {
                                MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.colorBrand)
                            } else {
                                MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                            },
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> AssetsTab()
                1 -> TransactionTab()
            }
        }
    }
}

