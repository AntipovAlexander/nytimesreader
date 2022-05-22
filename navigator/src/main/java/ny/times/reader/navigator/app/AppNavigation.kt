package ny.times.reader.navigator.app

interface AppNavigation {
    fun navigateToNewsDetails(
        headline: String,
        abstract: String,
        leadParagraph: String,
        image: String,
        sourceName: String,
        sourceUrl: String,
        tags: Array<String>
    )

    fun navigateBack()
}