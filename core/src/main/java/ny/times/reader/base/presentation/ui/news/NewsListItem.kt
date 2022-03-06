package ny.times.reader.base.presentation.ui.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ny.times.reader.base.R
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun NewsListItem(
    modifier: Modifier = Modifier,
    data: NewsUiEntity
) {
    Row(
        modifier = Modifier
            .then(modifier)
            .wrapContentHeight()
            .fillMaxHeight()
            .padding(horizontal = 16.dp)
            .aspectRatio(390f / 147f)
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f),
            painter = rememberImagePainter(
                data = data.thumb,
                builder = {
                    placeholder(R.drawable.image_paceholder)
                    crossfade(true)
                }
            ),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            contentDescription = null
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = data.title,
                style = TimesReaderTheme.typography.H2Bold,
                overflow = TextOverflow.Ellipsis,
                maxLines = 4
            )
            Text(
                text = data.authorName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = TimesReaderTheme.colors.grey,
                style = TimesReaderTheme.typography.H3Regular,
                modifier = Modifier.padding(top = 4.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = data.postedAgo,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = TimesReaderTheme.colors.grey,
                    style = TimesReaderTheme.typography.H3Regular,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .fillMaxWidth()
                        .weight(1f)
                )
                Icon(
                    painter = painterResource(R.drawable.ic_more),
                    contentDescription = null,
                    modifier = Modifier.clickable { }
                )
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    widthDp = 360,
    heightDp = 720
)
fun NewsListItemPreview() {
    val data = NewsUiEntity(
        "https://google.com",
        "https://google.com",
        "Monarch population soars population soars  4,900 percent since last year in thrilling 2021 western migration",
        "by John Doe",
        "2 days ago"
    )
    NewsListItem(data = data)
}