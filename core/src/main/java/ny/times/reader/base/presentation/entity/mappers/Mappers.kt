package ny.times.reader.base.presentation.entity.mappers

import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import java.text.SimpleDateFormat

fun News.toUiModel(
    dateFormat: SimpleDateFormat,
    socialTimeFormatter: SocialTimeFormatter
): NewsUiEntity = NewsUiEntity(
    id = id,
    thumb = thumbUrl,
    title = title,
    authorName = authorName ?: "",
    postedAgo = socialTimeFormatter.getTimeAgo(dateFormat.parse(postedAt)?.time ?: 0L)
)