package ny.times.reader.feed.domain.use_case

import kotlinx.coroutines.flow.Flow
import ny.times.reader.base.domain.base.FlowUseCase
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class ObserveNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) :
    FlowUseCase<Unit, List<News>>() {

    override fun executeOnBackground(params: Unit): Flow<List<News>> = newsRepository.newsFlow

}