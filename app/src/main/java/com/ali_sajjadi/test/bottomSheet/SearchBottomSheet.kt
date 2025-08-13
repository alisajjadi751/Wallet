package com.ali_sajjadi.test.bottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.SearchTextField
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
) {

    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )


    /*val sheetState = rememberModalBottomSheetState()*/

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
                text = "Search wallet",
                style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                SearchTextField(
                    modifier = Modifier
                        .height(50.dp)
                        .weight(1f)
                )

                CustomButton(
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp),
                    isSelected = true,
                    background = LocalCustomColors.current.secondaryButton,
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
                    isSelected = true,
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
                            Icon(
                                painter = painterResource(R.drawable.ic_qr),
                                contentDescription = "search",
                                tint = Color.Unspecified
                            )

                            Text(
                                text = "Scan",
                                style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
                            )
                        }

                    }
                )

                CustomButton(
                    modifier = Modifier
                        .height(40.dp)
                        .weight(1f),
                    isSelected = true,
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
                                text = "Choose ecosystem",
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
            }

            RecentSearches()
            //ResultSearch()


        }
    }
}



fun shortenMiddle(text: String, visibleChars: Int = 20): String {
    if (text.length <= visibleChars) return text
    val keep = visibleChars / 2
    return text.take(keep) + "..." + text.takeLast(keep)
}