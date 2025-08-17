package com.ali_sajjadi.test.topWallet

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
import com.ali_sajjadi.test.CustomTextField
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.h4
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.utils.Constants
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TopWalletScreen(modifier: Modifier = Modifier) {

    var showEcosystemBottomSheet by remember { mutableStateOf(false) }
    var selectedEcosystem by remember { mutableStateOf<String?>(null) }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(bottom = 30.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomTextField(
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f),
                background = LocalCustomColors.current.textFieldSearch2,
                hint = "Search in top wallet"
            )

            CustomButton(
                modifier = Modifier
                    .height(48.dp)
                    .width(48.dp),
                secondaryButton = true,
                strokeColor = Color.Transparent,
                background = LocalCustomColors.current.textFieldSearch2,
                onClick = {
                    /*TODO()*/
                },
                content = {
                    Icon(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = "search",
                        tint = Color.Unspecified
                    )
                }
            )
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

                    showEcosystemBottomSheet = true
                    /*TODO()*/
                },
                content = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "sort by ecosystem",
                            style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
                        )
                        Icon(
                            painter = painterResource(R.drawable.ic_arrow_down),
                            contentDescription = "search",
                            tint = Color.Unspecified
                        )
                    }

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
                    /*TODO()*/
                },
                content = {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "sort by token",
                            style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)

                        )

                        /*Icon(
                            painter = painterResource(R.drawable.ic_arrow_down),
                            contentDescription = "search",
                            tint = Color.Unspecified
                        )*/
                    }

                }
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(50) {
                TopWalletItem(

                )
            }
        }

    }
    if (showEcosystemBottomSheet) {
        EcosystemBottomSheet(
            ecosystems = listOf("Ethereum", "Polygon", "BSC"),//get from api
            selected = selectedEcosystem,
            onSelect = { eco ->
                selectedEcosystem = eco
                showEcosystemBottomSheet = false
            },
            onDismiss = { showEcosystemBottomSheet = false }
        )
    }

}

@Composable
fun TopWalletItem(
    modifier: Modifier = Modifier,
    number: Int = 1,
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6",
    balance: Int = 93437467,
    tokenAmount: Float = 232234231f,
    symbol: String = "ETH",
    isAdmin: Boolean = false,
    isTrackAvailable: Boolean = false,
    onDelete : () -> Unit = {}
) {

    val scope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current
    var isCopied by remember { mutableStateOf(false) }
    var isTracked by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(
                text = number.toString(),
                style = MaterialTheme.typography.h4.copy(color = LocalCustomColors.current.primaryText)
            )

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Row1
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        if(isAdmin){
                            Icon(
                                painter = painterResource(R.drawable.ic_delete),
                                contentDescription = if (isCopied) "copied" else "copy",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(16.dp)
                                    .clickable {
                                        onDelete()
                                    }
                            )
                        }

                        Text(
                            text = shortenMiddle(address, 20),
                            style = MaterialTheme.typography.h5
                                .copy(color = LocalCustomColors.current.primaryText)
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
                        text = "$ " + Constants.separator.format(balance).toString(),
                        style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                    )
                }

                //Row2
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(5.dp)
                    ) {
                        Icon(
                            painterResource(R.drawable.ic_ethereum),
                            contentDescription = "token icon",
                            tint = Color.Unspecified,
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = Constants.separator.format(tokenAmount).toString() + " $symbol",
                            style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(if (isFavorite) R.drawable.ic_star else R.drawable.ic_outlinstar),
                            contentDescription = "favorite",
                            modifier = Modifier
                                .size(25.dp)
                                .clickable { isFavorite = !isFavorite },
                            tint = Color.Unspecified
                        )

                        if (!isTrackAvailable){
                            CustomButton(
                                secondaryButton = isTracked,
                                modifier = Modifier
                                    .size(width = 70.dp, height = 30.dp),
                                radius = 10.dp,
                                onClick = {
                                    isTracked = !isTracked
                                }

                            ) {
                                Text(
                                    text = if (isTracked) "Untrack" else "Track",
                                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                                )
                            }
                        }else{
                            Box(
                                modifier = Modifier
                                    .size(width = 70.dp, height = 30.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "----",
                                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.secondaryText),

                                )
                            }

                        }

                    }
                }
            }
        }
        HorizontalDivider(
            color = LocalCustomColors.current.secondaryLine,
            modifier = Modifier.fillMaxWidth(0.6f)
        )
    }

}