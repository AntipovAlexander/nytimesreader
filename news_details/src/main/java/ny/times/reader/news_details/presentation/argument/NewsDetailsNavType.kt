package ny.times.reader.news_details.presentation.argument

import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class NewsDetailsNavType : NavType<NewsDetailsData>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): NewsDetailsData =
        bundle.getParcelable(key) ?: throw RuntimeException("Nullable argument is not allowed")

    override fun parseValue(value: String) = Json.decodeFromString<NewsDetailsData>(value)

    override fun put(bundle: Bundle, key: String, value: NewsDetailsData) =
        bundle.putParcelable(key, value)

}