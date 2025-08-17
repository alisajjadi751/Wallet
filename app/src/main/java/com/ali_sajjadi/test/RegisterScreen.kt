package com.ali_sajjadi.test

import ParticleScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.TextFieldSearch2Dark
import com.ali_sajjadi.test.ui.theme.h1
import com.ali_sajjadi.test.ui.theme.h7
import com.ali_sajjadi.test.ui.theme.h8
import com.ali_sajjadi.test.ui.theme.h9

//@Composable
//@Preview("RegisterScreen", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//fun LoginScreenPreview() {
//    TestTheme {
//        RegisterScreen()
//    }
//}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {

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
                text = "Register", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h1.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold))

            Text(modifier = Modifier.padding(top = 22.dp),
                text = "Create a new account", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h9.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 35.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = email,
                    hint = "Email",
                    icon = R.drawable.ic_email,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = { email = it }
                )

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

            Column(
                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CustomButton(modifier = Modifier.fillMaxWidth().height(40.dp), radius = 18.dp, onClick = {} ) {

                    Text(text = "Register", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                            fontWeight = FontWeight.Medium))

                }

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    HorizontalDivider(modifier = Modifier.padding(start = 18.dp)
                        .width(120.dp), color = LocalCustomColors.current.primaryLine, thickness = 1.dp)

                    Text(modifier = Modifier.padding(horizontal = 4.dp),
                        text = "or", color = LocalCustomColors.current.primaryLine,
                        style = MaterialTheme.typography.h8.copy(fontSize = 14.sp,
                            fontWeight = FontWeight.Medium))

                    HorizontalDivider(modifier = Modifier.padding(end = 18.dp)
                        .width(120.dp), color = LocalCustomColors.current.primaryLine, thickness = 1.dp)
                }

                CustomButton(modifier = Modifier.fillMaxWidth().height(40.dp),
                    secondaryButton = true, strokeColor = LocalCustomColors.current.outlinedButtonBrand,
                    radius = 16.dp, onClick = {} ) {

                    Row(modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Image(modifier = Modifier.padding(end = 8.dp),
                            painter = painterResource(R.drawable.ic_google),
                            contentDescription = null)

                        Text(text = "Continue with Google", color = LocalCustomColors.current.primaryText,
                            style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                                fontWeight = FontWeight.Medium))

                    }

                }

                Column(modifier = Modifier.padding(top = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp) ,
                    horizontalAlignment = Alignment.CenterHorizontally) {

                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Text(text = "By signing up you agree to our ", color = LocalCustomColors.current.primaryText,
                            style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                                fontWeight = FontWeight.Medium))

                        Text(modifier = Modifier.clickable(true){ },
                            text = "Terms of Use", color = LocalCustomColors.current.primaryLine,
                            style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                                fontWeight = FontWeight.Medium))

                    }

                    Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Text(text = "and ", color = LocalCustomColors.current.primaryText,
                            style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                                fontWeight = FontWeight.Medium))

                        Text(modifier = Modifier.clickable(true){ },
                            text = "Privacy Policy", color = LocalCustomColors.current.primaryLine,
                            style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                                fontWeight = FontWeight.Medium))

                    }

                }

            }

        }

    }

}