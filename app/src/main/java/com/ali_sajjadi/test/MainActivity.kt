package com.ali_sajjadi.test

import ParticleScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import com.ali_sajjadi.test.bottomSheet.SearchBottomSheet
import com.ali_sajjadi.test.ui.theme.TestTheme
import kotlinx.coroutines.delay
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SearchBottomSheet()
                }


                //HomeScreen()
                //ParticleScreen()
            }
        }
    }
}


@Composable
fun GalaxyBackgroundFullScreen() {
    val circleCount = 50
    val circles = remember { mutableStateListOf<OrbitCircle>() }

    LaunchedEffect(Unit) {
        while (true) {
            circles.forEachIndexed { index, c ->
                var newAngle = c.angle - c.speed // خلاف عقربه ساعت
                if (newAngle < 0f) newAngle += 360f
                circles[index] = c.copy(angle = newAngle)
            }
            delay(50) // ~60fps
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {
        val center = Offset(size.width / 2, size.height / 2)
        val maxOrbit = max(size.width, size.height) / 2f

        // اگر لیست هنوز خالیه، ستاره‌ها رو بساز
        if (circles.isEmpty()) {
            val minOrbit = maxOrbit * 0.2f // نزدیک‌ترین دایره تا مرکز، 20٪ از شعاع
            val maxOrbitLimit = maxOrbit * 0.95f // دورترین دایره کمی قبل از لبه

            repeat(circleCount) { i ->
                // رنگ تصادفی بین چند رنگ کهکشانی
                val galaxyColors = listOf(
                    Color(0xFFFFFFFF), // سفید
                    Color(0xFFFFE4B5), // زرد کم‌رنگ
                    Color(0xFFFFC0CB), // صورتی
                    Color(0xFFADD8E6), // آبی روشن
                    Color(0xFFFF4500)  // قرمز/نارنجی
                )
                val randomColor = galaxyColors.random().copy(alpha = Random.nextFloat() * 0.5f + 0.3f)

                // سرعت و جهت تصادفی (ممکنه مثبت یا منفی باشه)
                val randomSpeed = (Random.nextFloat() * 0.5f + 0.1f) * if (Random.nextBoolean()) 1 else -1


            }
            repeat(circleCount) { i ->
                circles.add(
                    OrbitCircle(
                        angle = Random.nextFloat() * 360f,
                        orbitRadius = Random.nextFloat() * (maxOrbitLimit - minOrbit) + minOrbit,
                        baseSize = Random.nextFloat() * 8f + 4f,
                        speed = (Random.nextFloat() * 0.5f + 0.1f),
                        color = Color(0xff4D1300).copy(alpha = 0.35f) // اصلاح آلفا
                    )
                )
            }
        }


        circles.forEach { c ->
            val rad = Math.toRadians(c.angle.toDouble())
            val x = center.x + cos(rad) * c.orbitRadius
            val y = center.y + sin(rad) * c.orbitRadius

            // عمق: هرچه نزدیک‌تر به مرکز → بزرگتر و پررنگ‌تر
            val depthFactor = 1f - (c.orbitRadius / maxOrbit).coerceIn(0f, 1f)
            val size = c.baseSize * (0.5f + depthFactor)
            val alpha = 0.3f + depthFactor * 0.7f

            drawCircle(
                color = c.color.copy(alpha = alpha),
                radius = size,
                center = Offset(x.toFloat(), y.toFloat())
            )
        }
    }
}

data class OrbitCircle(
    val angle: Float,
    val orbitRadius: Float,
    val baseSize: Float,
    val speed: Float,
    val color: Color
)









