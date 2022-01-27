package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun CircularProgress(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        CircularProgressIndicator(color = TimesReaderTheme.colors.black)
    }
}

@Composable
@Preview
fun CircularProgressPreview() {
    CircularProgress()
}