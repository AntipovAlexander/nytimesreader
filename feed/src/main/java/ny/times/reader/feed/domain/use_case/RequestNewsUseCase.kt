package ny.times.reader.feed.domain.use_case

import ny.times.reader.base.domain.base.UseCase
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class RequestNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) :
    UseCase<RequestNewsUseCase.Params, Unit>() {

    override suspend fun executeOnBackground(params: Params) =
        newsRepository.getNewsForCategory(params.category, params.page)

    data class Params(val category: String, val page: Int)

}