package ny.times.reader.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.presentation.ui.SearchBar
import ny.times.reader.base.presentation.ui.Toolbar

@Composable
fun Search() {
    Column {
        Toolbar(text = stringResource(R.string.search))
        SearchBar(modifier = Modifier.padding(all = 16.dp)) {

        }
    }
}

@Preview
@Composable
fun SearchPreview() {
    Search()
}