package ny.times.reader.feed.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ny.times.reader.base.data.entity.Dto
import ny.times.reader.base.utils.asImageUrl
import ny.times.reader.feed.domain.entity.News

@Serializable
data class NewsList(val response: Response) : Dto<List<News>> {

    companion object {
        private const val THUMB_SUBTYPE = "smallSquare168"
        private const val IMAGE_SUBTYPE = "master1050"
    }

    @Serializable
    data class Response(val docs: List<Doc>)

    @Serializable
    data class Doc(
        @SerialName("_id")
        val id: String,
        val abstract: String,
        @SerialName("web_url")
        val url: String,
        val snippet: String,
        @SerialName("lead_paragraph")
        val leadParagraph: String,
        @SerialName("pub_date")
        val pubDate: String,
        val headline: Headline,
        val byline: Byline,
        val multimedia: List<Multimedia>
    )

    @Serializable
    data class Headline(val main: String)

    @Serializable
    data class Byline(val original: String? = null)

    @Serializable
    data class Multimedia(val url: String, val subType: String)

    override fun convert(): List<News> {
        return this.response.docs.map { doc ->
            News(
                id = doc.id,
                imageUrl = doc.multimedia.firstOrNull { it.subType == IMAGE_SUBTYPE }?.url?.asImageUrl()
                    ?: "",
                thumbUrl = doc.multimedia.firstOrNull { it.subType == THUMB_SUBTYPE }?.url?.asImageUrl()
                    ?: "",
                title = doc.headline.main,
                snippet = doc.snippet,
                leadParagraph = doc.leadParagraph,
                authorName = doc.byline.original,
                postedAt = doc.pubDate,
                url = doc.url
            )
        }
    }
}