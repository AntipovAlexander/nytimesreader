package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun ListCircularProgress(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .then(modifier)
    ) {
        CircularProgressIndicator(color = TimesReaderTheme.colors.black)
    }
}