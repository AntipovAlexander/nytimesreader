package ny.times.reader.feed.domain.use_case

import ny.times.reader.base.domain.UseCase
import ny.times.reader.feed.domain.entity.Topic
import javax.inject.Inject

class GetTopicsUseCase @Inject constructor() : UseCase<Unit, List<Topic>>() {
    override suspend fun executeOnBackground(params: Unit): List<Topic> {
        return listOf(
            Topic(1, "Culture"),
            Topic(2, "Science"),
            Topic(3, "Education"),
            Topic(4, "Fashion"),
            Topic(5, "Health"),
            Topic(6, "Media"),
            Topic(7, "Business"),
            Topic(8, "Movies"),
            Topic(9, "Society"),
            Topic(10, "Weather")
        )
    }
}