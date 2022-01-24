package ny.times.reader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.theme.TimesReaderTheme

@AndroidEntryPoint
class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimesReaderTheme {
                Surface(
                    color = TimesReaderTheme.colors.lightGrey,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) { AppActivityUi() }
            }
        }
    }
}
