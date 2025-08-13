package com.ali_sajjadi.test

import ParticleScreen
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h5
import com.ali_sajjadi.test.ui.theme.h8

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColors.current.background),
        contentAlignment = Alignment.Center
    ) {

        ParticleScreen()
        //GalaxyBackgroundFullScreen()

        Column(
            modifier = modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(40.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = R.drawable.img_binoculars),
                contentDescription = "binoculars",
                modifier = modifier
                    .width(280.dp)
                    .height(130.dp)
            )

            CustomButton(
                modifier = Modifier
                    .width(124.dp)
                    .height(40.dp),
                onClick = {

                }
            ) {
                Text(
                    text = "Search wallet",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Track wallets",
                    style = MaterialTheme.typography.h8.copy(color = LocalCustomColors.current.primaryText)
                )
                Text(
                    text = "Discover balances, tokens, and transactions",
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                )
                Text(
                    text = "Just enter an address",
                    style = MaterialTheme.typography.h5.copy(color = LocalCustomColors.current.primaryText)
                )
            }
        }
    }
}
