package ny.times.reader.feed.domain.use_case

import ny.times.reader.base.domain.UseCase
import ny.times.reader.feed.domain.entity.News
import ny.times.reader.feed.domain.repository.NewsRepository
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) : UseCase<Unit, List<News>>() {
    override suspend fun executeOnBackground(params: Unit): List<News> {
        return newsRepository.getNewsForCategory("Sports")
    }
}