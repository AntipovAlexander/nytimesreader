package ny.times.reader.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class TimesReaderElevation(val default: Dp)

val elevation = TimesReaderElevation(default = 4.dp)

internal val LocalElevations = staticCompositionLocalOf { elevation }
