package ny.times.reader.base.presentation.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun Chip(
    chip: ChipContent,
    onSelectionChanged: (ChipContent) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = CircleShape,
        color = if (chip.isSelected)
            TimesReaderTheme.colors.black
        else
            TimesReaderTheme.colors.lightGrey
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = chip.isSelected,
                onValueChange = { onSelectionChanged(chip) }
            )
        ) {
            Text(
                text = chip.text,
                style = TimesReaderTheme.typography.H2Bold,
                color = if (chip.isSelected)
                    TimesReaderTheme.colors.white
                else
                    TimesReaderTheme.colors.grey,
                modifier = Modifier.padding(
                    start = 24.dp, end = 24.dp,
                    top = 6.dp, bottom = 6.dp
                )
            )
        }
    }
}

data class ChipContent(val id: Int, val text: String, val isSelected: Boolean)