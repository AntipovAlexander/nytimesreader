package ny.times.reader.base.presentation.ui.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun EnterAlwaysScaffold(
    toolbar: @Composable (modifier: Modifier) -> Unit,
    enterAlwaysBar: @Composable (modifier: Modifier) -> Unit,
    scrollableContent: @Composable (modifier: Modifier) -> Unit
) {
    val enterAlwaysBarHeight = remember { mutableStateOf(0) }
    val toolbarHeight = rememberSaveable { mutableStateOf(0) }

    val enterAlwaysBarOffset = remember { mutableStateOf(0f) }
    val contentOffset = remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newEnterAlwaysBarOffset = enterAlwaysBarOffset.value + delta
                val newContentOffset = contentOffset.value + delta
                enterAlwaysBarOffset.value = newEnterAlwaysBarOffset.coerceIn(
                    0f,
                    toolbarHeight.value.toFloat()
                )
                contentOffset.value = newContentOffset.coerceIn(
                    0f,
                    toolbarHeight.value + enterAlwaysBarHeight.value.toFloat(),
                )
                return Offset.Zero
            }
        }
    }

    Box(modifier = Modifier.nestedScroll(nestedScrollConnection)) {
        scrollableContent(
            Modifier.graphicsLayer { translationY = contentOffset.value }
        )
        enterAlwaysBar(
            Modifier
                .onGloballyPositioned {
                    enterAlwaysBarHeight.value = it.size.height
                    contentOffset.value = it.size.height + toolbarHeight.value.toFloat()
                }
                .graphicsLayer { translationY = enterAlwaysBarOffset.value }
        )
        toolbar(
            Modifier.onGloballyPositioned {
                toolbarHeight.value = it.size.height
                enterAlwaysBarOffset.value = it.size.height.toFloat()
            }
        )
    }

}