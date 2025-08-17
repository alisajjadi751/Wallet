package com.ali_sajjadi.test

import ParticleScreen
import android.content.res.Configuration
import android.util.Log
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.component.CustomButton
import com.ali_sajjadi.test.ui.theme.LocalCustomColors
import com.ali_sajjadi.test.ui.theme.TestTheme
import com.ali_sajjadi.test.ui.theme.TextFieldSearch2Dark
import com.ali_sajjadi.test.ui.theme.body4
import com.ali_sajjadi.test.ui.theme.h1
import com.ali_sajjadi.test.ui.theme.h7
import com.ali_sajjadi.test.ui.theme.h8
import com.ali_sajjadi.test.ui.theme.h9
import androidx.compose.ui.input.key.Key
import kotlinx.coroutines.delay
import java.util.Locale


//"alisajjadi@gmail.com"
//@Composable
//@Preview("VerifyEmailScreen", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
//fun LoginScreenPreview() {
//    TestTheme {
//        VerifyEmailScreen(email = "alisajjadi@gmail.com")
//    }
//}

@Composable
fun VerifyEmailScreen(modifier: Modifier = Modifier, email: String) {

    var isEnableResendCode by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LocalCustomColors.current.background),
        contentAlignment = Alignment.Center
    ) {

        ParticleScreen()
//        GalaxyBackgroundFullScreen()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.Transparent),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(
                modifier = Modifier
                    .size(30.dp, 30.dp)
                    .clickable(
                        true,
                        onClick = {})
                    .align(Alignment.Start),
                color = TextFieldSearch2Dark,
                shape = RoundedCornerShape(15.dp)
            ) {

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

            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Verify Email", color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h1.copy(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = "Verify your email below to proceed",
                color = LocalCustomColors.current.primaryText,
                style = MaterialTheme.typography.h9.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Text(
                modifier = Modifier.padding(top = 84.dp),
                textAlign = TextAlign.Center,
                text = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryText)) {
                        append("Enter the ")
                    }
                    withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryLine)) {
                        append("6 digits code ")
                    }
                    withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryText)) {
                        append("sent to your email address\n")
                    }
                    withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryLine)) {
                        append(email)
                    }
                }, style = MaterialTheme.typography.h9.copy(
                    fontSize = 12.sp, fontWeight = FontWeight.Medium,
                    lineHeight = 25.sp
                )
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(top = 38.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val numbers = remember { mutableStateListOf(*Array(6) { "" }) }
                OtpTextFields(length = numbers.size, values = numbers) { value, i ->
                    numbers[i] = value
                }

                var timeLeft by remember { mutableStateOf(60) }
                CountdownTimer(timeLeft, { timeLeft = it }, {
                    isEnableResendCode = true
                })

                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryText)) {
                            append("Code expires in ")
                        }
                        withStyle(style = SpanStyle(color = LocalCustomColors.current.primaryLine)) {
                            append(String.format(Locale.UK,"00:%02ds", timeLeft))
                        }
                    }, color = LocalCustomColors.current.primaryText,
                    style = MaterialTheme.typography.h8.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                )

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(text = "Didn’t get code? ", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h8.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        ))

                    Text(modifier = Modifier.clickable(isEnableResendCode)
                    { timeLeft = 60
                      isEnableResendCode = false },
                        text = "Resend Code", color = LocalCustomColors.current.primaryLine,
                        style = MaterialTheme.typography.h8.copy(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            textDecoration = if (isEnableResendCode) TextDecoration.Underline else TextDecoration.None
                        ))
                }

            }

            Box(modifier = Modifier.padding(top = 55.dp)
                .padding(horizontal = 10.dp)) {
                CustomButton(modifier = Modifier.fillMaxWidth().height(40.dp), radius = 18.dp, onClick = {} ) {

                    Text(text = "Submit", color = LocalCustomColors.current.primaryText,
                        style = MaterialTheme.typography.h7.copy(fontSize = 16.sp,
                            fontWeight = FontWeight.Medium))

                }
            }

        }

    }

}

@Composable
fun CountdownTimer(
    time: Int ,
    onTimeChange: (Int) -> Unit = {},
    onTimeFinished: () -> Unit = {}
) {
    LaunchedEffect(key1 = time) {
        if (time > 0){
            delay(1000)
            onTimeChange(time - 1)
        } else {
            onTimeFinished()
        }
    }
}

@Composable
fun OtpTextFields(
    length: Int = 6,
    values: SnapshotStateList<String>,
    onValueChange: (String, Int) -> Unit,
) {

    val focusRequesters = List(length) { FocusRequester() }
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until length) {
            BasicTextField(
                value = values[i],
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        onValueChange(newValue, i)
                        if (newValue.isNotEmpty() && i < length - 1) {
                            focusRequesters[i + 1].requestFocus()
                        }
                    }
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                cursorBrush = SolidColor(LocalCustomColors.current.cursor),
                textStyle = MaterialTheme.typography.body4.copy(
                    color = LocalCustomColors.current.primaryText,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(LocalCustomColors.current.textFieldSearch2)
                    .focusRequester(focusRequesters[i])
                    .onKeyEvent { keyEvent ->
                        if (keyEvent.type == KeyEventType.KeyUp && keyEvent.key == Key.Backspace) {
                            if (values[i].isEmpty() && i > 0) {
                                focusRequesters[i - 1].requestFocus()
                                onValueChange("", i - 1)
                            }
                            return@onKeyEvent true
                        } else {
                            return@onKeyEvent false
                        }
                    },
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) { innerTextField() }
                })
        }
    }

}


//                Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
//                    verticalAlignment = Alignment.CenterVertically) {
//
////                    for(i in numbers.indices) {
////
////                        TextFieldNumber(value = numbers[i]) { numbers[i] = it}
////
////                    }
//
////                    TextFieldNumber(value = number1) { number1 = it}
////                    TextFieldNumber(value = number2) { number2 = it}
////                    TextFieldNumber(value = number3) { number3 = it}
////                    TextFieldNumber(value = number4) { number4 = it}
////                    TextFieldNumber(value = number5) { number5 = it}
////                    TextFieldNumber(value = number6) { number6 = it}
//
//                }

//@Composable
//fun TextFieldNumber(
//    modifier: Modifier = Modifier, value: String,
//    keyboardOptions: KeyboardOptions =
//        KeyboardOptions(keyboardType = KeyboardType.Number),
//    radius: RoundedCornerShape = RoundedCornerShape(6.dp),
//    background: Color = LocalCustomColors.current.textFieldSearch2,
//    onValueChange: (String) -> Unit = {},
//) {
//
//    BasicTextField(
//        value = value,
//        onValueChange = {
//            if (it.length <= 1) { // فقط یک کاراکتر
//                onValueChange(it)
//            }
//        },
//        singleLine = true,
//        keyboardOptions = keyboardOptions,
//        cursorBrush = SolidColor(LocalCustomColors.current.cursor),
//        textStyle = MaterialTheme.typography.body4.copy(
//            color = LocalCustomColors.current.primaryText,
//            textAlign = TextAlign.Center
//        ),
//        modifier = modifier
//            .size(40.dp)
//            .clip(radius)
//            .background(background),
//        decorationBox = { innerTextField ->
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center  // وسط افقی و عمودی
//            ) {
//                innerTextField()
//            }
//        }
//    )
//
//}