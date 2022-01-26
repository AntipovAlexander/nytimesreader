package ny.times.reader.feed.presentation.data

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.feed.domain.entity.News
import ny.times.reader.feed.domain.entity.Topic

fun Topic.toUiModel(isSelected: Boolean = false): ChipContent = ChipContent(id, name, isSelected)

fun News.toUiModel(): NewsUiEntity = NewsUiEntity(id, imageUrl, title, authorName, postedAgo)