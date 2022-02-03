package ny.times.reader.base.data.pagination

class PaginationDelegate(
    private val datasetSize: () -> Int,
    private val isPaginationInProgress: () -> Boolean,
    private val requestNextPage: () -> Unit,
    private val pageThreshold: Int = 5
) {
    fun paginate(currentPosition: Int) {
        val nearTheEnd = currentPosition >= datasetSize() - pageThreshold
        val paginationIsAllowed = !isPaginationInProgress()
        if (nearTheEnd && paginationIsAllowed) requestNextPage()
    }
}