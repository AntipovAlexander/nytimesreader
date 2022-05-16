package ny.times.reader.navigation

interface FeedNavigator {
    fun goToNewsDetails(
        headline: String,
        abstract: String,
        leadParagraph: String,
        image: String,
        sourceName: String,
        sourceUrl: String,
        tags: List<String>
    )
}