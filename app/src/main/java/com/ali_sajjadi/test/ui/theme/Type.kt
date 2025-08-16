package com.ali_sajjadi.test.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ali_sajjadi.test.R
val InterFontFamily = FontFamily(
    Font(R.font.inter)
)


val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

val font = FontFamily(
    Font(R.font.inter)
)
val Typography.body1: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Thin,
        fontSize = 10.sp,
        lineHeight = 20.sp
    )
val Typography.body2: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 12.sp,
        lineHeight = 22.sp
    )

val Typography.body3: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 24.sp
    )

val Typography.body4: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 20.sp
    )
val Typography.body5: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 28.sp
    )

val Typography.body6: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

val Typography.body7: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 22.sp,
        lineHeight = 32.sp
    )

val Typography.h1: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Thin,
        fontSize = 6.sp,
        lineHeight = 14.sp
    )

val Typography.h2: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.ExtraLight,
        fontSize = 8.sp,
        lineHeight = 16.sp
    )

val Typography.h3: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Light,
        fontSize = 10.sp,
        lineHeight = 18.sp
    )

val Typography.h4: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 20.sp
    )

val Typography.h5: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 22.sp
    )

val Typography.h6: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,

        )

val Typography.h7: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 26.sp
    )

val Typography.h8: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 20.sp,
        lineHeight = 28.sp
    )

val Typography.h9: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Black,
        fontSize = 22.sp,
        lineHeight = 30.sp
    )

