package com.ali_sajjadi.test.walletInfo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h4
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.utils.Constants

@Composable
fun AssetsTab(modifier: Modifier = Modifier) {

    val topTitles = listOf(
        "Token/Price", "Amounts", "Value"
    )

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text = "#",
            style = MaterialTheme.typography.h4.copy(color = LocalCustomColors.current.secondaryText)
        )
        Row(
            modifier = modifier.padding(start = 10.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            topTitles.forEach {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.secondaryText)
                )
            }
        }
    }
}

@Composable
fun AssetItem(
    modifier: Modifier = Modifier,
    number : Int = 1,
    tokenName: String = "1inch Network",
    priceToken: Double = 0.8877,
    tokenAmount: Float = 35352345345f
) {

    Row(
        modifier = modifier.fillMaxWidth().height(40.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.h4.copy(color = LocalCustomColors.current.primaryText)
        )
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ){
                AsyncImage(
                    model = R.drawable.bnb,
                    contentDescription = "token icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(30.dp),
                    placeholder = null,
                    error = null
                )
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = tokenName,
                        style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                    )

                    Text(
                        text = priceToken.toString(),
                        style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                    )
                }
            }

                Text(
                    text = Constants.separator.format(tokenAmount).toString(),
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                )

                Text(
                    text = Constants.separator.format(tokenAmount*priceToken).toString(),
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                )



        }
    }

}
