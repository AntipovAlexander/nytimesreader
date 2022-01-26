package ny.times.reader.feed.presentation.data

data class NewsUiEntity(
    val id: String,
    val thumb: String,
    val title: String,
    val authorName: String,
    val postedAgo: String,
)