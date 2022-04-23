package ny.times.reader.news_details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ny.times.reader.base.R
import ny.times.reader.base.presentation.ui.widget.CollapsingToolbarScaffold
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.news_details.presentation.argument.NewsDetailsData

@Composable
fun NewsDetails(details: NewsDetailsData) {
    CollapsingToolbarScaffold(
        title = { modifier, color, fontSize ->
            Text(
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier,
                text = details.headline,
                style = TimesReaderTheme.typography.H3Bold,
                color = color,
                fontSize = fontSize
            )

        },
        image = { modifier ->
            Image(
                modifier = modifier,
                painter = rememberImagePainter(
                    data = details.image,
                    builder = { placeholder(R.drawable.image_paceholder); crossfade(true) }
                ),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = null
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(all = 16.dp)
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = LocalConfiguration.current.screenHeightDp.dp)
            ) {
                Text(
                    text = details.abstract,
                    style = TimesReaderTheme.typography.arcticTitle
                )
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = generateByLine(details),
                    style = TimesReaderTheme.typography.H3Regular,
                    color = TimesReaderTheme.colors.grey
                )
                Text(
                    text = details.leadParagraph,
                    style = TimesReaderTheme.typography.H1Regular
                )
                TextButton(
                    onClick = {
                        // todo
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Continue reading on source ...",
                        color = TimesReaderTheme.colors.black,
                        style = TimesReaderTheme.typography.H1Regular
                    )
                }
            }
        }
    )
}

fun generateByLine(details: NewsDetailsData): String {
    val byline = "By: ${details.sourceName}, "
    val tags = "tags: " + details.tags.joinToString(separator = ", ")
    return byline + tags
}