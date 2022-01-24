package ny.times.reader.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.ui.Toolbar

@Composable
fun Feed() {
    Column {
        Toolbar(text = stringResource(R.string.feed))
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}