package ny.times.reader.news_details.presentation

import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
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
            // todo
        }
    )
}