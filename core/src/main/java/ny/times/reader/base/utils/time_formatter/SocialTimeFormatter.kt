package ny.times.reader.base.utils.time_formatter

interface SocialTimeFormatter {
    fun getTimeAgo(timeInput: Long): String
}