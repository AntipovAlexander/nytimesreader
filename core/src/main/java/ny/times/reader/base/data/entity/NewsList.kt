package ny.times.reader.base.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ny.times.reader.base.data.entity.base.Dto
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.utils.asImageUrl

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
        @SerialName("source")
        val source: String,
        @SerialName("pub_date")
        val pubDate: String,
        val headline: Headline,
        val byline: Byline,
        @SerialName("keywords")
        val keywords: List<Keyword>,
        val multimedia: List<Multimedia>
    ) : Dto<News> {
        override fun convert(): News = News(
            id = id,
            imageUrl = multimedia.firstOrNull { it.subType == IMAGE_SUBTYPE }?.url?.asImageUrl()
                ?: "",
            thumbUrl = multimedia.firstOrNull { it.subType == THUMB_SUBTYPE }?.url?.asImageUrl()
                ?: "",
            title = headline.main,
            snippet = snippet,
            leadParagraph = leadParagraph,
            authorName = byline.original,
            source = source,
            postedAt = pubDate,
            url = url,
            keywords = keywords.map { it.value }
        )
    }

    @Serializable
    data class Headline(val main: String)

    @Serializable
    data class Byline(val original: String? = null)

    @Serializable
    data class Multimedia(val url: String, val subType: String)

    @Serializable
    data class Keyword(val value: String)

    override fun convert(): List<News> {
        return this.response.docs.map { doc -> doc.convert() }
    }
}