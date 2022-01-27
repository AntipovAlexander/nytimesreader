package ny.times.reader.base.domain.entity

data class News(
    val id: String,
    val imageUrl: String,
    val thumbUrl: String,
    val title: String,
    val snippet: String,
    val leadParagraph: String,
    val authorName: String?,
    val postedAt: String,
    val url: String
)