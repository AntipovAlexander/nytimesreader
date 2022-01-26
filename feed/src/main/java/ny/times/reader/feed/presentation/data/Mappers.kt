package ny.times.reader.feed.presentation.data

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import ny.times.reader.feed.domain.entity.News
import ny.times.reader.feed.domain.entity.Topic
import java.text.SimpleDateFormat

fun Topic.toUiModel(isSelected: Boolean = false): ChipContent = ChipContent(id, name, isSelected)

fun News.toUiModel(
    dateFormat: SimpleDateFormat,
    socialTimeFormatter: SocialTimeFormatter
): NewsUiEntity = NewsUiEntity(
    id = id,
    thumb = thumbUrl,
    title = title,
    authorName = authorName,
    postedAgo = socialTimeFormatter.getTimeAgo(dateFormat.parse(postedAt)?.time ?: 0L)
)