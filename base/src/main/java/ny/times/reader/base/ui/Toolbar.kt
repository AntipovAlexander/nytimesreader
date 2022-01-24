package ny.times.reader.base.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun Toolbar(modifier: Modifier = Modifier, text: String) {
    TopAppBar(modifier = modifier, backgroundColor = TimesReaderTheme.colors.white) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = TimesReaderTheme.colors.black,
                style = TimesReaderTheme.typography.H1Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewToolbar() {
    Toolbar(text = "preview")
}