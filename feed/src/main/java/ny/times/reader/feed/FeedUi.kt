package ny.times.reader.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Feed() {
    Column {
        TopAppBar(title = { Text(stringResource(R.string.tab_title)) })
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}