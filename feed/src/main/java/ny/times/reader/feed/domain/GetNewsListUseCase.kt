package ny.times.reader.feed.domain

import ny.times.reader.base.domain.UseCase
import ny.times.reader.feed.domain.entity.News
import javax.inject.Inject

class GetNewsListUseCase @Inject constructor() : UseCase<Unit, List<News>>() {
    override suspend fun executeOnBackground(params: Unit): List<News> {
        val news = mutableListOf<News>()
        for (i in 1L..10L) {
            val data = News(
                i,
                "https://images.unsplash.com/photo-1534353436294-0dbd4bdac845?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1287&q=80",
                "Monarch population soars population soars  4,900 percent since last year in thrilling 2021 western migration",
                "by John Doe${i}",
                "$i days ago"
            )
            news.add(data)
        }
        return news
    }
}