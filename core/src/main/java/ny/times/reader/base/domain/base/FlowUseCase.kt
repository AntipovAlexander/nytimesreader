package ny.times.reader.base.domain.base

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in Params, out ResultType> where Params : Any {

    protected abstract fun executeOnBackground(params: Params): Flow<ResultType>

    open operator fun invoke(params: Params): Flow<ResultType> =
        executeOnBackground(params)
            .flowOn(Dispatchers.IO)
}
