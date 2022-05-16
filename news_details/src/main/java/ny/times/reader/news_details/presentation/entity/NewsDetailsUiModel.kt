package ny.times.reader.news_details.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class NewsDetailsUiModel(
    val headline: String,
    val abstract: String,
    val leadParagraph: String,
    val image: String,
    val sourceName: String,
    val sourceUrl: String,
    val tags: List<String>
) : Parcelable {
    companion object {
        val EMPTY = NewsDetailsUiModel("", "", "", "", "", "", emptyList())
    }
}