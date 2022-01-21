package ny.times.reader.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

object TimesReaderTheme {
    val colors: TimesReaderColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current
    val typography: TimesReaderTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
    val dimensions: TimesReaderElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalElevations.current
}

@Composable
fun TimesReaderTheme(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalElevations provides elevation,
        LocalTypography provides typography
    ) { content() }
}
