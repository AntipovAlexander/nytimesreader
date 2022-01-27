package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.R
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    text: String = "",
    onTextChanged: (String) -> Unit
) {
    Surface(
        color = TimesReaderTheme.colors.lightGrey,
        modifier = Modifier
            .then(modifier)
            .height(40.dp),
        shape = RoundedCornerShape(40.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { onTextChanged(it) },
            textStyle = TimesReaderTheme.typography.H1Regular,
            singleLine = true,
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = TimesReaderTheme.colors.grey
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    ) {
                        if (text.isEmpty()) Text(
                            text = stringResource(id = R.string.search),
                            style = TimesReaderTheme.typography.H1Regular,
                            color = TimesReaderTheme.colors.grey
                        )
                        innerTextField()
                    }
                    IconButton(
                        onClick = { onTextChanged("") }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cancel),
                            contentDescription = null,
                            tint = if (text.isEmpty())
                                TimesReaderTheme.colors.grey
                            else
                                TimesReaderTheme.colors.black
                        )
                    }
                }
            }
        )
    }
}

@Composable
@Preview
fun SearchBarPreview() {
    SearchBar {}
}