package ny.times.reader.base.utils.provider

import android.graphics.Typeface
import androidx.annotation.FontRes
import androidx.annotation.PluralsRes

interface ResourceProvider {
    fun getString(resourceIdentifier: Int, vararg arguments: Any = arrayOf()): String

    fun getStringArray(resourceIdentifier: Int): Array<String>

    fun getQuantityString(
        @PluralsRes pluralResId: Int,
        quantity: Int,
        vararg formatArgs: Any
    ): String

    fun getInteger(resourceIdentifier: Int): Int

    fun getIntegerArray(resourceIdentifier: Int): Array<Int>

    fun getBoolean(resourceIdentifier: Int): Boolean

    fun getColor(resourceIdentifier: Int): Int

    fun getDimen(resourceIdentifier: Int): Float

    fun getTypeface(@FontRes font: Int): Typeface?
}
