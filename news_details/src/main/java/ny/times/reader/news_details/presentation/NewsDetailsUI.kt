package ny.times.reader.news_details.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun NewsDetails() {
    Text(text = "Hello news", style = TimesReaderTheme.typography.H1Bold)
}