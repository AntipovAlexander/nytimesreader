package ny.times.reader.feed.domain.entity

data class News(
    val id: Long,
    val imageUrl: String,
    val title: String,
    val authorName: String,
    val postedAgo: String,
)