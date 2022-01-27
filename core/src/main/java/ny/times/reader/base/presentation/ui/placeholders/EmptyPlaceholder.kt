package ny.times.reader.base.presentation.ui.placeholders

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.R
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun EmptyPlaceholder(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.default_empty_text)
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = text,
                style = TimesReaderTheme.typography.H1Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
@Preview
fun SimplePlaceholderPreview() {
    EmptyPlaceholder()
}