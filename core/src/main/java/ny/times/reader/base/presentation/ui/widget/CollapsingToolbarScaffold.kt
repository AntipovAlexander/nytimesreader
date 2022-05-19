package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ny.times.reader.base.theme.TimesReaderTheme
import java.math.RoundingMode

val HeaderHeightCollapsed = 48.dp
val HeaderHeightExpanded = 200.dp

val HeaderElevationCollapsed = 4.dp
val HeaderElevationExpanded = 0.dp

val TitleSizeCollapsed = 16.sp
val TitleSizeExpanded = 28.sp

val TitleOffsetCollapsed = 48.dp
val TitleOffsetExpanded = 16.dp

@Composable
fun CollapsingToolbarScaffold(
    title: @Composable (modifier: Modifier, color: Color, fontSize: TextUnit) -> Unit,
    image: @Composable (modifier: Modifier) -> Unit,
    onBackPressed: () -> Unit,
    content: @Composable () -> Unit
) {
    val slideOffsetInPx = with(LocalDensity.current) {
        (HeaderHeightExpanded - HeaderHeightCollapsed).toPx()
    }
    val collapsedRatio = remember { mutableStateOf(1f) }
    val offsetState = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                offsetState.value = offsetState.value + consumed.y
                collapsedRatio.value = (1f + offsetState.value / slideOffsetInPx)
                    .coerceIn(0f, 1f)
                    .round()
                return super.onPostScroll(consumed, available, source)
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .nestedScroll(nestedScrollConnection)
            .wrapContentHeight()
    ) {
        item { Spacer(modifier = Modifier.height(HeaderHeightExpanded)) }
        item { content() }
    }

    TopAppBar(
        contentPadding = PaddingValues(0.dp),
        modifier = Modifier.height(
            calculate(
                collapsedRatio.value,
                HeaderHeightCollapsed,
                HeaderHeightExpanded,
            )
        ),
        backgroundColor = TimesReaderTheme.colors.white,
        elevation = calculate(
            collapsedRatio.value,
            HeaderElevationCollapsed,
            HeaderElevationExpanded
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            image(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(calculate(collapsedRatio.value, 0f, 1f))
            )
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = resolveColor(collapsedRatio.value)
                )
            }
            title(
                modifier = Modifier
                    .align(alignment = Alignment.BottomStart)
                    .padding(
                        start = calculate(
                            collapsedRatio.value,
                            TitleOffsetCollapsed,
                            TitleOffsetExpanded,
                        ),
                        end = 8.dp
                    )
                    .offset(y = (-14).dp),
                fontSize = calculate(collapsedRatio.value, TitleSizeCollapsed, TitleSizeExpanded),
                color = resolveColor(collapsedRatio.value),
            )
        }
    }
}

@Composable
private fun resolveColor(collapsedRatio: Float) =
    if (collapsedRatio <= 0.15f) Color.DarkGray else Color.White

@Composable
fun calculate(collapsedRatio: Float, collapsed: Dp, expanded: Dp): Dp {
    val delta = expanded - collapsed
    return with(LocalDensity.current) { (collapsed.toPx() + collapsedRatio * delta.toPx()).toDp() }
}

@Composable
fun calculate(collapsedRatio: Float, collapsed: TextUnit, expanded: TextUnit) =
    with(LocalDensity.current) {
        val delta = expanded.toPx() - collapsed.toPx()
        (collapsed.toPx() + collapsedRatio * delta).toSp()
    }

@Composable
fun calculate(collapsedRatio: Float, collapsed: Float, expanded: Float): Float {
    val delta = expanded - collapsed
    return collapsed + collapsedRatio * delta
}

private fun Float.round() = this
    .toBigDecimal()
    .setScale(5, RoundingMode.UP)
    .toFloat()