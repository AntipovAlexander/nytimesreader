package ny.times.reader.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.ui.Toolbar

@Composable
fun Search() {
    Column {
        Toolbar(text = stringResource(R.string.search))
        Text(text = stringResource(R.string.search))
    }
}

@Preview
@Composable
fun SearchPreview() {
    Search()
}