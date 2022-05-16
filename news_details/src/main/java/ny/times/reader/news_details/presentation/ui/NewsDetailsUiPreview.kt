package ny.times.reader.news_details.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiModel

@Preview
@Composable
fun NewsDetailsUiPreview() {
    val newsDetails = NewsDetailsUiModel(
        headline = "Test headline",
        abstract = "test abstract",
        leadParagraph = "test lead paragraph",
        image = "",
        sourceName = "New York Times",
        sourceUrl = "",
        tags = listOf("tag1", "tag2", "tag3", "tag4")
    )
    NewsDetailsUi(
        details = newsDetails,
        onBackPressed = {}
    )
}