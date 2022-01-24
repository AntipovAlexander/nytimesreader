package ny.times.reader.feed.domain

import ny.times.reader.base.domain.UseCase
import ny.times.reader.feed.domain.entity.Topic
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor() : UseCase<Unit, List<Topic>>() {
    override suspend fun executeOnBackground(params: Unit): List<Topic> {
        return listOf(
            Topic(1, "Culture"),
            Topic(2, "Science"),
            Topic(3, "Technologies"),
            Topic(4, "Music"),
            Topic(5, "Arts"),
            Topic(6, "Investment"),
            Topic(7, "Business")
        )
    }
}