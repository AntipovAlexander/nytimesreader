package ny.times.reader.base.utils

import ny.times.reader.base.BuildConfig

fun String.asImageUrl() = BuildConfig.BASE_URL + this