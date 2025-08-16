package com.ali_sajjadi.test.topWallet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.CustomTextField
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.h4
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TopWalletScreen(modifier: Modifier = Modifier) {

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

    }

}

@Composable
fun TopWalletItem(
    modifier: Modifier = Modifier,
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6",
    number : Int = 1
    ) {

    val scope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current
    var isCopied by remember { mutableStateOf(false) }

    Row {

        Text(
            text = number.toString(),
            style = MaterialTheme.typography.h4.copy(color = LocalCustomColors.current.primaryText)
        )

        Column {

            Row {
                Text(
                    text = "",
                    style = MaterialTheme.typography.body3
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

        }


    }

}