package com.example.liverpooltestproductsearch.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


private val LightColorPalette = LiverpoolColors(
    brand = Shadow5,
    brandSecondary = Ocean3,
    uiBackground = Neutral0,
    uiBorder = Neutral4,
    uiFloated = FunctionalGrey,
    textSecondary = Neutral7,
    textHelp = Neutral6,
    textInteractive = Neutral0,
    textLink = Ocean11,
    iconSecondary = Neutral7,
    iconInteractive = Neutral0,
    iconInteractiveInactive = Neutral1,
    error = FunctionalRed,
    gradient6_1 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient6_2 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient3_1 = listOf(Shadow2, Ocean3, Shadow4),
    gradient3_2 = listOf(Rose2, Lavender3, Rose4),
    gradient2_1 = listOf(Shadow4, Shadow11),
    gradient2_2 = listOf(Ocean3, Shadow3),
    gradient2_3 = listOf(Lavender3, Rose2),
    tornado1 = listOf(Shadow4, Ocean3),
    lvpLoading = Rose8,
    isDark = false
)

private val DarkColorPalette = LiverpoolColors(
    brand = Shadow1,
    brandSecondary = Ocean2,
    uiBackground = Neutral8,
    uiBorder = Neutral3,
    uiFloated = FunctionalDarkGrey,
    textPrimary = Shadow1,
    textSecondary = Neutral0,
    textHelp = Neutral1,
    textInteractive = Neutral7,
    textLink = Ocean2,
    iconPrimary = Shadow1,
    iconSecondary = Neutral0,
    iconInteractive = Neutral7,
    iconInteractiveInactive = Neutral6,
    error = FunctionalRedDark,
    gradient6_1 = listOf(Shadow5, Ocean7, Shadow9, Ocean7, Shadow5),
    gradient6_2 = listOf(Rose11, Lavender7, Rose8, Lavender7, Rose11),
    gradient3_1 = listOf(Shadow9, Ocean7, Shadow5),
    gradient3_2 = listOf(Rose8, Lavender7, Rose11),
    gradient2_1 = listOf(Ocean3, Shadow3),
    gradient2_2 = listOf(Ocean4, Shadow2),
    gradient2_3 = listOf(Lavender3, Rose3),
    tornado1 = listOf(Shadow4, Ocean3),
    lvpLoading = Rose8,
    isDark = true
)

@Composable
fun LiverpoolTestProductSearchTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    ProvideLiverpoolColors(colors) {
        MaterialTheme(
            colorScheme = debugColors(darkTheme),
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}

@Composable
fun ProvideLiverpoolColors(
    colors: LiverpoolColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalLiverpoolColors provides colors, content = content)
}

object LiverpoolTestProductSearchTheme {
    val colors: LiverpoolColors
        @Composable
        get() = LocalLiverpoolColors.current
}

private val LocalLiverpoolColors = staticCompositionLocalOf<LiverpoolColors> {
    error("No JetsnackColorPalette provided")
}


/**
 * Jetsnack custom Color Palette
 */
@Immutable
data class LiverpoolColors(
    val gradient6_1: List<Color>,
    val gradient6_2: List<Color>,
    val gradient3_1: List<Color>,
    val gradient3_2: List<Color>,
    val gradient2_1: List<Color>,
    val gradient2_2: List<Color>,
    val gradient2_3: List<Color>,
    val brand: Color,
    val brandSecondary: Color,
    val uiBackground: Color,
    val uiBorder: Color,
    val uiFloated: Color,
    val interactivePrimary: List<Color> = gradient2_1,
    val interactiveSecondary: List<Color> = gradient2_2,
    val interactiveMask: List<Color> = gradient6_1,
    val textPrimary: Color = brand,
    val textSecondary: Color,
    val textHelp: Color,
    val textInteractive: Color,
    val textLink: Color,
    val tornado1: List<Color>,
    val iconPrimary: Color = brand,
    val iconSecondary: Color,
    val iconInteractive: Color,
    val iconInteractiveInactive: Color,
    val error: Color,
    val notificationBadge: Color = error,
    val lvpLoading: Color,
    val isDark: Boolean
)


fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = ColorScheme(
    primary = debugColor,
    onPrimary = debugColor,
    primaryContainer = debugColor,
    onPrimaryContainer = debugColor,
    inversePrimary = debugColor,
    secondary = debugColor,
    onSecondary = debugColor,
    secondaryContainer = debugColor,
    onSecondaryContainer = debugColor,
    tertiary = debugColor,
    onTertiary = debugColor,
    tertiaryContainer = debugColor,
    onTertiaryContainer = debugColor,
    background = debugColor,
    onBackground = debugColor,
    surface = debugColor,
    onSurface = debugColor,
    surfaceVariant = debugColor,
    onSurfaceVariant = debugColor,
    surfaceTint = debugColor,
    inverseSurface = debugColor,
    inverseOnSurface = debugColor,
    error = debugColor,
    onError = debugColor,
    errorContainer = debugColor,
    onErrorContainer = debugColor,
    outline = debugColor,
    outlineVariant = debugColor,
    scrim = debugColor,
    surfaceBright = debugColor,
    surfaceDim = debugColor,
    surfaceContainer = debugColor,
    surfaceContainerHigh = debugColor,
    surfaceContainerHighest = debugColor,
    surfaceContainerLow = debugColor,
    surfaceContainerLowest = debugColor,
)