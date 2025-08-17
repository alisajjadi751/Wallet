package com.ali_sajjadi.test.topWallet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ali_sajjadi.test.CustomTextField
import com.ali_sajjadi.test.R
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.h4
import com.ali_sajjadi.test.ui.theme.h6
import com.ali_sajjadi.test.ui.theme.h7

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWalletDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {}
) {

    var allowTracking by remember { mutableStateOf(false) }

    BasicAlertDialog(
        onDismissRequest = onDismissRequest
    ) {

        Column(
            modifier = modifier
                .size(320.dp)
                .background(LocalCustomColors.current.alertDialog, RoundedCornerShape(28.dp))
                .clip(RoundedCornerShape(28.dp))
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_close),
                contentDescription = "close",
                modifier = Modifier
                    .size(16.dp)
                    .align(alignment = Alignment.End),
                tint = LocalCustomColors.current.icon
            )

            Text(
                text = "Add Wallet",
                style = MaterialTheme.typography.h7.copy(color = LocalCustomColors.current.primaryText)
            )

            CustomTextField(
                content = {
                    CustomButton(
                        modifier = Modifier.size(width = 70.dp, height = 30.dp),
                        onClick = {}
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {

                            Icon(
                                painter = painterResource(R.drawable.ic_ethereum),
                                contentDescription = "ecosystem icon",
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(15.dp)
                            )

                            Icon(
                                painterResource(R.drawable.ic_arrow_down),
                                contentDescription = "arrow down",
                                tint = Color.Unspecified
                            )
                        }
                    }
                }
            )

            CustomTextField(
                hint = "Name Tag",

                )

            AllowCheckBox(
                checked = allowTracking,
                onCheckedChange = { allowTracking = it }
            )

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                onClick = {

                }
            ) {

                Text(
                    text = "submit",
                    style = MaterialTheme.typography.h6.copy(color = LocalCustomColors.current.primaryText)
                )
            }
        }
    }
}

@Composable
fun AllowCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit = {}
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            modifier = Modifier.size(20.dp),
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(LocalCustomColors.current.colorBrand),

        )
        Text(
            text = "Allow tracking by users",
            style = MaterialTheme.typography.h4.copy(color = LocalCustomColors.current.primaryText)
        )
    }
}
