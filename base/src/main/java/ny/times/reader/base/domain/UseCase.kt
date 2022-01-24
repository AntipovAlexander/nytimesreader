package ny.times.reader.base.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ny.times.reader.base.domain.entity.Either
import ny.times.reader.base.domain.entity.runCatching

abstract class UseCase<in Params, out ResultType> where Params : Any {

    var defaultDispatcher = Dispatchers.IO

    protected abstract suspend fun executeOnBackground(params: Params): ResultType

    open suspend operator fun invoke(params: Params): Either<Exception, ResultType> =
        runCatching { withContext(defaultDispatcher) { executeOnBackground(params) } }

}
