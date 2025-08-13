import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.ali_sajjadi.test.homeBackground.ParticleGLSurfaceView

@Composable
fun ParticleScreen() {
    // state: whether to move on touch
    var moveOnTouch by remember { mutableStateOf(true) }

    AndroidView(
        factory = { ctx ->
            ParticleGLSurfaceView(ctx).apply {
                enableTouchMovement(moveOnTouch)
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}