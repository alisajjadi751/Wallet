package com.ali_sajjadi.test.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


val LocalCustomColors = staticCompositionLocalOf { LightCustomColors }
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun TestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val customColors = if (darkTheme) DarkCustomColors else LightCustomColors
    CompositionLocalProvider(LocalCustomColors provides customColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }

}


@Immutable
data class CustomColors(
    val colorBrand: Color,
    val background: Color,
    val bgNavDrawer: Color,
    val icon: Color,
    val iconBrand: Color,
    val iconCopy: Color,
    val primaryButton: Brush,
    val secondaryButton: Color,
    val outlinedButtonBrand: Color,
    val outlinedButton: Color,
    val bgBottomBar: Color,
    val bottomSheet: Color,
    val textFieldSearch: Color,
    val textFieldSearch2: Color,
    val hintTextFieldSearch: Color,
    val primaryText: Color,
    val secondaryText: Color,
    val snackBar: Color,
    val cursor: Color,
    val primaryLine: Color,
    val secondaryLine: Color,
    val alertDialog: Color
)

val LightCustomColors = CustomColors(
    colorBrand = ColorBrand,
    background = BackgroundLight,
    bgNavDrawer = BgNavDrawerLight,
    icon = IconLight,
    iconBrand = IconBrandLight,
    iconCopy = IconCopyLight,
    primaryButton = PrimaryButtonLight,
    secondaryButton = SecondaryButtonLight ,
    outlinedButtonBrand = OutlinedButtonBrandLight,
    outlinedButton = OutlinedButtonLight,
    bgBottomBar = BgBottomBarLight,
    bottomSheet = BottomSheetLight,
    textFieldSearch = TextFieldSearchLight,
    textFieldSearch2 = TextFieldSearch2Light,
    hintTextFieldSearch = HintTextFieldSearchLight,
    primaryText = PrimaryTextLight,
    secondaryText = SecondaryTextLight,
    snackBar = SnackBarLight,
    cursor = CursorLight,
    primaryLine = PrimaryLineLight,
    secondaryLine = SecondaryLineLight,
    alertDialog = AlertDialogLight
)

val DarkCustomColors = CustomColors(
    colorBrand = ColorBrand,
    background = BackgroundDark,
    bgNavDrawer = BgNavDrawerDark,
    icon = IconDark,
    iconBrand = IconBrandDark,
    iconCopy = IconCopyDark,
    primaryButton = PrimaryButtonDark,
    secondaryButton = SecondaryButtonDark,
    outlinedButtonBrand = OutlinedButtonBrandDark,
    outlinedButton = OutlinedButtonDark,
    bgBottomBar = BgBottomBarDark,
    bottomSheet = BottomSheetDark,
    textFieldSearch = TextFieldSearchDark,
    textFieldSearch2 = TextFieldSearch2Dark,
    hintTextFieldSearch = HintTextFieldSearchDark,
    primaryText = PrimaryTextDark,
    secondaryText = SecondaryTextDark,
    snackBar = SnackBarDark,
    cursor = CursorDark,
    primaryLine = PrimaryLineDark,
    secondaryLine = SecondaryLineDark,
    alertDialog = AlertDialogDark
)
