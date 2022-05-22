package ny.times.reader.news_details.presentation.entity

data class NewsDetailsUiEntity(
    val headline: String,
    val abstract: String,
    val leadParagraph: String,
    val image: String,
    val sourceName: String,
    val sourceUrl: String,
    val tags: List<String>
)