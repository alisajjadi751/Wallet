package com.ali_sajjadi.test

import ParticleScreen
import android.content.res.Configuration
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.TextFieldSearch2Dark
import com.ali_sajjadi.test.ui.theme.body3
import com.ali_sajjadi.test.ui.theme.body4
import com.ali_sajjadi.test.ui.theme.h1
import com.ali_sajjadi.test.ui.theme.h7
import com.ali_sajjadi.test.ui.theme.h8
import com.ali_sajjadi.test.ui.theme.h9

//@Composable
//@Preview("LoginScreen", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//fun LoginScreenPreview() {
//    TestTheme {
//        LoginScreen()
//    }
//}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize()
        .background(LocalCustomColors.current.background),
        contentAlignment = Alignment.Center) {

        ParticleScreen()
//        GalaxyBackgroundFullScreen()

        Column(modifier = modifier.fillMaxSize()
            .padding( 16.dp)
            .background(color = Color.Transparent),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Surface(modifier = modifier.size(30.dp, 30.dp)
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

            Text(modifier = modifier.padding(top = 16.dp),
                text = "Welcome back", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h1.copy(fontSize = 32.sp, fontWeight = FontWeight.Bold))

            Text(modifier = modifier.padding(top = 22.dp),
                text = "Login to your account", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h9.copy(fontSize = 12.sp, fontWeight = FontWeight.Medium))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 52.dp),
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

                Text(modifier = modifier.align(Alignment.End).clickable(true){ },
                    text = "Forgot  Password?", color = LocalCustomColors.current.primaryText,
                    style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                        fontWeight = FontWeight.Medium, textDecoration = TextDecoration.Underline))
            }

            Column(
                modifier = Modifier.padding(horizontal = 10.dp).padding(top = 25.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp) ,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CustomButton(modifier = Modifier.fillMaxWidth().height(40.dp), radius = 18.dp, onClick = {} ) {

                    Text(text = "Login", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                            fontWeight = FontWeight.Medium))

                }

                Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    HorizontalDivider(modifier = modifier.padding(start = 18.dp)
                        .width(120.dp), color = LocalCustomColors.current.primaryLine, thickness = 1.dp)

                    Text(modifier = modifier.padding(horizontal = 4.dp),
                        text = "or", color = LocalCustomColors.current.primaryLine,
                        style = MaterialTheme.typography.h8.copy(fontSize = 14.sp,
                            fontWeight = FontWeight.Medium))

                    HorizontalDivider(modifier = modifier.padding(end = 18.dp)
                        .width(120.dp), color = LocalCustomColors.current.primaryLine, thickness = 1.dp)
                }

                CustomButton(modifier = modifier.fillMaxWidth().height(40.dp),
                    isSelected = true, strokeColor = LocalCustomColors.current.outlinedButtonBrand,
                    radius = 16.dp, onClick = {} ) {

                    Row(modifier = modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                        Image(modifier = modifier.padding(end = 8.dp),
                            painter = painterResource(R.drawable.ic_google),
                            contentDescription = null)

                        Text(text = "Continue with Google", color = LocalCustomColors.current.primaryText,
                            style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                                fontWeight = FontWeight.Medium))

                    }

                }

                Row(modifier = modifier.padding(top = 30.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(text = "Don’t have an account? ", color = LocalCustomColors.current.primaryLine,
                        style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                            fontWeight = FontWeight.Medium))

                    Text(modifier = modifier.clickable(true){ },
                        text = "Register", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h9.copy(fontSize = 12.sp,
                            fontWeight = FontWeight.Medium),textDecoration = TextDecoration.Underline)

                }

            }

        }

    }

}

@Composable
fun TextField(
    modifier: Modifier = Modifier,
    value: String = "",
    textError: String = "",
    hint: String,
    icon: Int,
    iconChangeState: Int = -1,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onValueChange: (String) -> Unit = {}
) {

    val isVisible = remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(LocalCustomColors.current.textFieldSearch2),
        keyboardOptions = keyboardOptions,
        singleLine = true,
        cursorBrush = SolidColor(LocalCustomColors.current.cursor),
        visualTransformation = if (iconChangeState == -1 || isVisible.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
        textStyle = MaterialTheme.typography.body4.copy(
            color = LocalCustomColors.current.primaryText
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
                    if (value.isEmpty()) {
                        Text(
                            text = hint,
                            style = MaterialTheme.typography.body3.copy(
                                color = LocalCustomColors.current.hintTextFieldSearch
                            )
                        )
                    }
                    innerTextField()
                }

                Icon(
                    painter = painterResource(if(iconChangeState == -1) icon else {
                        if (isVisible.value) icon else iconChangeState
                    }),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable(if (iconChangeState != -1) true else false) {
                            isVisible.value = !isVisible.value },
                    tint = Color.Unspecified
                )
            }
        }
    )
}