package ny.times.reader.feed.domain.use_case

import android.util.Log
import ny.times.reader.base.domain.base.UseCase
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class RequestNewsUseCase @Inject constructor(private val newsRepository: NewsRepository) :
    UseCase<RequestNewsUseCase.Params, Unit>() {

    override suspend fun executeOnBackground(params: Params) {
        Log.d("tag", "requesting page# ${params.page}")
        newsRepository.getNewsForCategory(params.category, params.page)
    }

    data class Params(val category: String, val page: Int)

}