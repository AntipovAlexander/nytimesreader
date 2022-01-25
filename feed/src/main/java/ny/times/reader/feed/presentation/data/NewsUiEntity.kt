package ny.times.reader.feed.presentation.data

data class NewsUiEntity(
    val id: Long,
    val imageUrl: String,
    val title: String,
    val authorName: String,
    val postedAgo: String,
)