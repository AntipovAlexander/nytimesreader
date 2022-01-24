package ny.times.reader.bookmarks

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.presentation.ui.Toolbar

@Composable
fun Bookmarks() {
    Column {
        Toolbar(text = stringResource(R.string.bookmarks))
    }
}

@Preview
@Composable
fun SearchPreview() {
    Bookmarks()
}