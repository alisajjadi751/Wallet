package com.ali_sajjadi.test

import ParticleScreen
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.TestTheme
import com.ali_sajjadi.test.ui.theme.TextFieldSearch2Dark
import com.ali_sajjadi.test.ui.theme.h1
import com.ali_sajjadi.test.ui.theme.h7
import com.ali_sajjadi.test.ui.theme.h9

//@Composable
//@Preview("LoginScreen", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//fun LoginScreenPreview() {
//    TestTheme {
//        NewPasswordScreen()
//    }
//}

@Composable
fun NewPasswordScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()
        .background(LocalCustomColors.current.background),
        contentAlignment = Alignment.Center) {

        ParticleScreen()
//        GalaxyBackgroundFullScreen()

        Column(modifier = Modifier.fillMaxSize()
            .padding( 16.dp)
            .background(color = Color.Transparent),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Surface(modifier = Modifier.size(30.dp, 30.dp)
                .clickable(true,
                    onClick = {})
                .align(Alignment.Start),
                color = TextFieldSearch2Dark,
                shape = RoundedCornerShape(15.dp)) {

                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Text(modifier = Modifier.padding(top = 16.dp),
                text = "New Password", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h1.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold))

            Text(modifier = Modifier.padding(top = 144.dp),
                text = "Please write your new password", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h9.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium))

            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 40.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextField(
                    value = password,
                    hint = "Password",
                    icon = R.drawable.ic_open_eyse,
                    iconChangeState = R.drawable.ic_close_eyse,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { password = it }
                )

                TextField(
                    value = confirmPassword,
                    hint = "Confirm Password",
                    icon = R.drawable.ic_open_eyse,
                    iconChangeState = R.drawable.ic_close_eyse,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = { confirmPassword = it }
                )
            }

            Box(modifier = Modifier.padding(top = 35.dp)
                .padding(horizontal = 10.dp)) {
                CustomButton(modifier = Modifier.fillMaxWidth().height(40.dp), radius = 18.dp, onClick = {} ) {

                    Text(text = "Confirm Password", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                            fontWeight = FontWeight.Medium))

                }
            }

//            Column(
//                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 25.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp) ,
//                horizontalAlignment = Alignment.CenterHorizontally
//            )

        }

    }

}