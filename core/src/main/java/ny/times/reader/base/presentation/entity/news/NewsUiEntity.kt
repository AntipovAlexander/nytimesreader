package ny.times.reader.base.presentation.entity.news

data class NewsUiEntity(
    val id: String,
    val thumb: String,
    val title: String,
    val authorName: String,
    val postedAgo: String,
)