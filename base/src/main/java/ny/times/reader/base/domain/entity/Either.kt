/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, fold express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ny.times.reader.base.domain.entity

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ny.times.reader.base.domain.entity.Either.Left
import ny.times.reader.base.domain.entity.Either.Right
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Left] or [Right].
 * FP Convention dictates that [Left] is used for "failure"
 * and [Right] is used for "success".
 *
 * @see Left
 * @see Right
 */
sealed class Either<out L, out R> {
    /** * Represents the left side of [Either] class which by convention is a "Failure". */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /** * Represents the right side of [Either] class which by convention is a "Success". */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun <L> left(a: L) = Left(a)
    fun <R> right(b: R) = Right(b)

    fun fold(fnR: (R) -> Any, fnL: (L) -> Any): Any =
        when (this) {
            is Left -> fnL(a)
            is Right -> fnR(b)
        }
}

// Credits to Alex Hart -> https://proandroiddev.com/kotlins-nothing-type-946de7d464fb
// Composes 2 functions
fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <R> Either<Exception, R?>.acceptNonNull(error: String = "Parameter can't be null") = flatMap {
    if (it != null)
        Right(it)
    else
        Left(RuntimeException(error))
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
    when (this) {
        is Left -> Left(a)
        is Right -> fn(b)
    }

fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::right))

inline fun <T, R> T.runCatching(block: T.() -> R): Either<Exception, R> {
    return try {
        Right(block())
    } catch (e: Exception) {
        if (e is CancellationException) throw e
        Left(e)
    }
}

fun <R> Either<Exception, R>.success(fnR: (R) -> Unit) {
    when (this) {
        is Left -> Timber.e(a)
        is Right -> fnR(b)
    }
}

suspend fun <R> Either<Exception, R>.doOnSuccess(fn: suspend (result: R) -> Unit): Either<Exception, R> =
    when (this) {
        is Left -> Left(a)
        is Right -> {
            fn(b)
            Right(b)
        }
    }

fun <R> Either<Exception, R>.error(fnL: (Exception) -> Unit) {
    when (this) {
        is Left -> fnL(a)
        is Right -> Unit
    }
}

suspend fun <R> Either<Exception, R>.doOnError(fn: suspend (e: Exception) -> Unit): Either<Exception, R> =
    when (this) {
        is Left -> {
            fn(this.a)
            this
        }
        is Right -> Right(b)
    }

fun <L, R> Either<L, R>.finally(action: () -> Unit): Either<L, R> {
    action.invoke()
    return this
}


fun <R> Either<Exception, R>.getOrThrow(): R = when (this) {
    is Left -> throw a
    is Right -> b
}

fun <L, R> Either<L, R>.getOrElse(value: R): R =
    when (this) {
        is Left -> value
        is Right -> b
    }

fun <R> Either<Exception, R?>.getOrNull(): R? = when (this) {
    is Left -> null
    is Right -> b
}

suspend fun <InputType, ReturnType> Either<Exception, InputType>.mapSuspendable(
    context: CoroutineContext = Dispatchers.IO,
    fn: suspend (it: InputType) -> Either<Exception, ReturnType>
): Either<Exception, InputType> = withContext(context) {
    when (this@mapSuspendable) {
        is Left -> Left(a)
        is Right -> when (val result = fn(this@mapSuspendable.b)) {
            is Left -> Left(result.a)
            is Right -> Right(this@mapSuspendable.b)
        }
    }
}

suspend fun <T, L, R> Either<L, R>.flatMapSuspendable(
    context: CoroutineContext = Dispatchers.IO,
    fn: suspend (R) -> Either<L, T>
): Either<L, T> = withContext(context) {
    when (this@flatMapSuspendable) {
        is Left -> Left(a)
        is Right -> fn(this@flatMapSuspendable.b)
    }
}

fun <U, R> Either<Exception, U>.zipWith(source: Either<Exception, R>): Either<Exception, Pair<U, R>> {
    return when {
        source is Left -> source
        this@zipWith is Left -> this@zipWith
        else -> Right((this@zipWith as Right).b to (source as Right).b)
    }
}

