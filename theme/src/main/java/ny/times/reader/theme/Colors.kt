package ny.times.reader.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class TimesReaderColors(
    val black: Color,
    val grey: Color,
    val lightGrey: Color,
    val white: Color
)

val colors = TimesReaderColors(
    black = Color(0xFF180E19),
    grey = Color(0xFF909090),
    lightGrey = Color(0xFFEEEEEE),
    white = Color(0xFFFFFFFF),
)

internal val LocalColors = staticCompositionLocalOf { colors }
