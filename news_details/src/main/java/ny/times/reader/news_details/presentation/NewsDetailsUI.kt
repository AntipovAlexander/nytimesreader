package ny.times.reader.news_details.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import ny.times.reader.base.R
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.news_details.presentation.argument.NewsDetailsData

@Composable
fun NewsDetails(details: NewsDetailsData) {
    val items = (1..100).map { "Item $it" }
    EnterAlwaysScaffold(
        toolbar = { scaffoldModifier ->
            Toolbar(modifier = scaffoldModifier, text = "Text title")
        },
        enterAlwaysBar = { scaffoldModifier ->
            Image(
                modifier = Modifier
                    .then(scaffoldModifier)
                    .height(300.dp),
                painter = rememberImagePainter(
                    data = details.image,
                    builder = {
                        placeholder(R.drawable.image_paceholder)
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                contentDescription = null
            )
        },
        scrollableContent = { scaffoldModifier ->
            Box(
                modifier = scaffoldModifier.then(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            ) {
                LazyColumn {
                    items(items) {
                        Text(text = "item", modifier = Modifier.fillMaxWidth())
                    }
                }
            }
        }
    )
}