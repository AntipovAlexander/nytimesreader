package ny.times.reader.base.data.entity.base

interface Dto<out T> {
    fun convert(): T
}

fun <T : Any> List<Dto<T?>>?.convert(): List<T> {
    return this?.mapNotNull { it.convert() } ?: emptyList()
}

