package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ChipGroup(
    modifier: Modifier,
    chips: List<ChipContent>,
    onSelectedChanged: (ChipContent) -> Unit = {},
) {
    Column(modifier = modifier) {
        LazyRow {
            chips.forEach {
                item {
                    Chip(
                        chip = it,
                        onSelectionChanged = { onSelectedChanged(it) },
                    )
                }
            }
        }
    }
}