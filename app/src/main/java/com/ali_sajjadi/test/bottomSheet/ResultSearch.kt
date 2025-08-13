package com.ali_sajjadi.test.bottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4

@Composable
fun ResultSearch(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "Result search",
                style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.colorBrand)
            )
            HorizontalDivider(
                color = LocalCustomColors.current.primaryLine
            )
        }

        FindResult()
        //NoResult()

    }


}

@Composable
fun NoResult(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "No result",
            style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
        )

        Text(
            text = "We couldn’t find any data for the address you entered",
            style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.secondaryText)
        )

        Text(
            text = "Please make sure the address is correct.",
            style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.secondaryText)
        )

    }

}

@Composable
fun FindResult(
    modifier: Modifier = Modifier,
    address: String = "0x57E9E78A627BaA30b71793885B952a9006298AF6"
) {

    Row (
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = shortenMiddle(address, 16),
            style = MaterialTheme.typography.body4.copy(color = LocalCustomColors.current.primaryText)
        )
        CustomButton(
            modifier = Modifier
                .height(30.dp)
                .width(70.dp),
            onClick = {}
        ) {
            Text(
                text = "Watch",
                style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)
            )

        }

        Button(
            onClick = {},
            modifier = Modifier
                .size(width = 70.dp, height = 30.dp),
            shape = RoundedCornerShape(15.dp),
            contentPadding = PaddingValues(0.dp) // متن وسط دکمه بمونه
        ) {
            Text(
                text = "Watch",
                style = MaterialTheme.typography.body3.copy(color = LocalCustomColors.current.primaryText)


            )
        }

    }


}