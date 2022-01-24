package ny.times.reader.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Bookmarks() {
    Column {
        TopAppBar(title = { Text(stringResource(R.string.bookmarks)) })
    }
}

@Preview
@Composable
fun SearchPreview() {
    Bookmarks()
}