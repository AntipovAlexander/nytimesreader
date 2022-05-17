package ny.times.reader.news_details.presentation.argument

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class NewsDetailsData(
    val headline: String,
    val abstract: String,
    val leadParagraph: String,
    val image: String,
    val sourceName: String,
    val sourceUrl: String,
    val tags: List<String>
) : Parcelable