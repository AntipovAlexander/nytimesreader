package ny.times.reader.feed.presentation.data

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.feed.domain.entity.Topic

fun Topic.toUiModel(isSelected: Boolean = false): ChipContent = ChipContent(id, name, isSelected)