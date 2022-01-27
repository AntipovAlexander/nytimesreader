package ny.times.reader.base.presentation.ui.placeholders

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.R
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun ErrorPlaceholder(
    modifier: Modifier = Modifier,
    errorText: String = stringResource(R.string.default_error_text),
    buttonText: String = stringResource(R.string.retry),
    onRetryClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = errorText, style = TimesReaderTheme.typography.H1Bold)
            Spacer(modifier = Modifier.height(6.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = TimesReaderTheme.colors.black,
                    contentColor = TimesReaderTheme.colors.white
                ),
                onClick = { onRetryClick() }
            ) {
                Text(text = buttonText, style = TimesReaderTheme.typography.H1Regular)
            }
        }
    }
}

@Composable
@Preview
fun ErrorPlaceholderPreview() {
    ErrorPlaceholder {

    }
}