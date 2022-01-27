package ny.times.reader.search.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.widget.SearchBar
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.search.R

@Composable
fun Search(searchVm: SearchViewModel = hiltViewModel()) {
    Column {
        Toolbar(text = stringResource(R.string.search))
        SearchBar(
            modifier = Modifier.padding(all = 16.dp),
            onTextChanged = {}
        )
    }
}

@Preview
@Composable
fun SearchPreview() {
    Search()
}