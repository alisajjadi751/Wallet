package com.ali_sajjadi.test.walletInfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
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
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.CustomTextField
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body5
import com.ali_sajjadi.test.ui.theme.h6
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoBottomSheet(
    modifier: Modifier = Modifier,
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6",
    nameTag: String = "Binance : Hot Wallet 20 ",
    name: String = "Wallet2",
    onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current
    var isCopied by remember { mutableStateOf(false) }
    var editName by remember { mutableStateOf(false) }

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = sheetState,
        containerColor = LocalCustomColors.current.bottomSheet,
        shape = RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Information",
                style = MaterialTheme.typography.body5.copy(color = LocalCustomColors.current.primaryText)
            )

            Spacer(modifier = Modifier.padding(vertical = 8.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {

                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = MaterialTheme.typography.body3.toSpanStyle()
                                    .copy(LocalCustomColors.current.secondaryText)
                            ) {
                                append("Wallet Address : ")
                            }
                            withStyle(
                                style = MaterialTheme.typography.body3.toSpanStyle()
                                    .copy(color = LocalCustomColors.current.primaryText)
                            ) {
                                append(shortenMiddle(address, 16))
                            }
                        },
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
                    text = buildAnnotatedString {
                        withStyle(
                            style = MaterialTheme.typography.body3.toSpanStyle()
                                .copy(LocalCustomColors.current.secondaryText)
                        ) {
                            append("Name tag : ")
                        }
                        withStyle(
                            style = MaterialTheme.typography.body3.toSpanStyle()
                                .copy(color = LocalCustomColors.current.primaryText)
                        ) {
                            append(nameTag)
                        }
                    }
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {

                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = MaterialTheme.typography.body3.toSpanStyle()
                                    .copy(LocalCustomColors.current.secondaryText)
                            ) {
                                append("Name : ")
                            }
                            if (!editName) {
                                withStyle(
                                    style = MaterialTheme.typography.body3.toSpanStyle()
                                        .copy(color = LocalCustomColors.current.primaryText)
                                ) {
                                    append(name)
                                }
                            }
                        },
                    )
                    if (editName) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            CustomTextField(
                                modifier = Modifier.weight(0.6f),
                                hint = "name",
                                value = name,
                                onValueChange = {/*todo*/ },
                                onClickClear = {/*todo*/ }
                            )

                            CustomButton(
                                modifier = Modifier
                                    .size(width = 70.dp, height = 30.dp),
                                radius = 10.dp,
                                onClick = {
                                    /*todo*/
                                }

                            ) {
                                Text(
                                    text = "Submit",
                                    style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                                )
                            }
                        }

                    }

                    Icon(
                        painter = painterResource(R.drawable.ic_edit),
                        contentDescription = "edit name",
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(16.dp)
                            .clickable {
                                editName = !editName

                            }
                    )

                }
            }
        }
    }
}