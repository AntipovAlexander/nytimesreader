package ny.times.reader.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

private val sfRegular = FontFamily(Font(R.font.sf_regular))
private val sfRegularItalic = FontFamily(Font(R.font.sf_regular_italic))
private val sfMedium = FontFamily(Font(R.font.sf_medium))
private val sfBold = FontFamily(Font(R.font.sf_bold))

@Immutable
data class TimesReaderTypography(
    val arcticTitle: TextStyle,
    val actionSheet: TextStyle,
    val imageCaption: TextStyle,
    val H1Bold: TextStyle,
    val H1Regular: TextStyle,
    val H2Bold: TextStyle,
    val H2Regular: TextStyle,
    val H3Bold: TextStyle,
    val H3Regular: TextStyle,
    val P1Regular: TextStyle
)

val typography = TimesReaderTypography(
    arcticTitle = TextStyle(fontFamily = sfBold, fontSize = 18.sp),
    actionSheet = TextStyle(fontFamily = sfRegular, fontSize = 18.sp),
    imageCaption = TextStyle(fontFamily = sfRegularItalic, fontSize = 12.sp),
    H1Bold = TextStyle(fontFamily = sfBold, fontSize = 15.sp),
    H1Regular = TextStyle(fontFamily = sfMedium, fontSize = 15.sp),
    H2Bold = TextStyle(fontFamily = sfBold, fontSize = 14.sp),
    H2Regular = TextStyle(fontFamily = sfMedium, fontSize = 14.sp),
    H3Bold = TextStyle(fontFamily = sfBold, fontSize = 13.sp),
    H3Regular = TextStyle(fontFamily = sfMedium, fontSize = 13.sp),
    P1Regular = TextStyle(fontFamily = sfRegular, fontSize = 15.sp)
)

internal val LocalTypography = staticCompositionLocalOf { typography }
