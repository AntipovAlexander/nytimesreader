package ny.times.reader.news_details.presentation.ui

import ny.times.reader.news_details.presentation.argument.NewsDetailsData

internal object PreviewData {
    fun get() = NewsDetailsData(
        headline = "Test headline",
        abstract = "Test abstract",
        leadParagraph = "Lead paragraph",
        image = "",
        sourceName = "NY Times",
        sourceUrl = "",
        tags = listOf("tag1", "tag2", "tag3", "tag4", "tag5")
    )
}
