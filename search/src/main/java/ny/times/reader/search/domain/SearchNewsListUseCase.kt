package ny.times.reader.search.domain

import ny.times.reader.base.domain.base.UseCase
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class SearchNewsListUseCase @Inject constructor(private val newsRepository: NewsRepository) :
    UseCase<String, List<News>>() {

    override suspend fun executeOnBackground(params: String): List<News> =
        newsRepository.searchNewsByQuery(params)
}