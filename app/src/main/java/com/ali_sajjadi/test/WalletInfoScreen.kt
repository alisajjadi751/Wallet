package com.ali_sajjadi.test

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.bottomSheet.shortenMiddle
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h4
import com.ali_sajjadi.test.ui.theme.h6
import com.ali_sajjadi.test.ui.theme.h8
import com.ali_sajjadi.test.ui.theme.h9
import com.ali_sajjadi.test.utils.Constants.separator

@Composable
fun WalletInfoScreen(
    modifier: Modifier = Modifier,
    address : String = "0x1234567890123456789012345678901234567890",
    balance : Int = 985456773
) {

    var isSelected by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            //.statusBarsPadding()
            .fillMaxSize()
            .background(LocalCustomColors.current.background)
            .padding(horizontal = 16.dp)

    ){

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

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){

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
                    Text(
                        text = shortenMiddle(text = address, visibleChars = 8),
                        style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                    )
                    Text(
                        text ="$ " + separator.format(balance) + " ETH",
                        style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                    )

                }

            }
val context = LocalCustomColors.current
            CustomButton(
                isSelected = isSelected,
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


    }

}