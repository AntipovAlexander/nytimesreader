package ny.times.reader.base.utils.time_formatter

import ny.times.reader.base.R
import ny.times.reader.base.utils.provider.ResourceProvider
import java.util.*
import javax.inject.Inject

class SocialTimeFormatterImpl @Inject constructor(
    private val resourceProvider: ResourceProvider
) : SocialTimeFormatter {

    companion object {
        private const val SECOND_MILLIS = 1000
        private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
        private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
        private const val DAY_MILLIS = 24 * HOUR_MILLIS

    }

    private val calendar by lazy { Calendar.getInstance() }

    override fun getTimeAgo(timeInput: Long): String {
        var time = timeInput
        if (time < 1000000000000L) {
            // if timestamp given in seconds, convert to millis
            time *= 1000
        }

        val now = calendar.time.time
        if (time > now || time <= 0) return resourceProvider.getString(R.string.in_the_future)
        val diff = now - time
        return when {
            diff < MINUTE_MILLIS -> resourceProvider.getString(R.string.moments_ago)
            diff < 2 * MINUTE_MILLIS -> resourceProvider.getString(R.string.a_minute_ago)
            diff < 50 * MINUTE_MILLIS -> resourceProvider.getString(
                R.string.x_minutes_ago,
                (diff / MINUTE_MILLIS).toInt()
            )
            diff < 90 * MINUTE_MILLIS -> resourceProvider.getString(R.string.an_hour_ago)
            diff < 24 * HOUR_MILLIS ->
                resourceProvider.getString(
                    R.string.x_hours_ago,
                    (diff / HOUR_MILLIS).toInt()
                )
            diff < 48 * HOUR_MILLIS -> resourceProvider.getString(R.string.yesterday)
            else -> resourceProvider.getString(
                R.string.x_days_ago,
                (diff / DAY_MILLIS).toInt()
            )

        }
    }
}