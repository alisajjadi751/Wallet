package com.ali_sajjadi.test.homeBackground

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import java.io.BufferedReader
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.tan

class ParticlesRenderer(
    private val context: Context,
    private val particleCount: Int = 200,
    private val particleSpread: Float = 10f,
    private val speed: Float = 0.1f,
    private val particleBaseSize: Float = 80f,
    private val sizeRandomness: Float = 1f,
    private val alphaParticles: Boolean = false,
    private val disableRotation: Boolean = false,
) : GLSurfaceView.Renderer {

    private var program = 0

    private lateinit var vertexBuffer: FloatBuffer
    private lateinit var randomBuffer: FloatBuffer
    private lateinit var colorBuffer: FloatBuffer

    private val projectionMatrix = FloatArray(16)
    private val viewMatrix = FloatArray(16)
    private val mvpMatrix = FloatArray(16)

    private var startTime = 0L

    // Touch interaction
    @Volatile private var touchX = 0f
    @Volatile private var touchY = 0f
    @Volatile private var moveOnTouch = false

    // particle mesh transform
    private var particlesPosX = 0f
    private var particlesPosY = 0f
    private var rotationX = 0f
    private var rotationY = 0f
    private var rotationZ = 0f

    fun setTouchNormalized(x: Float, y: Float) {
        touchX = x
        touchY = y
    }

    fun setMoveOnTouch(enabled: Boolean) {
        moveOnTouch = enabled
    }

    override fun onSurfaceCreated(unused: GL10?, config: EGLConfig?) {
        GLES20.glClearColor(0f, 0f, 0f, 0f)
        GLES20.glEnable(GLES20.GL_BLEND)
        GLES20.glBlendFunc(GLES20.GL_SRC_ALPHA, GLES20.GL_ONE_MINUS_SRC_ALPHA)
        GLES20.glDisable(GLES20.GL_DEPTH_TEST)

        val vertexCode = loadAssetText("shaders/vertex_shader.glsl")
        val fragCode = loadAssetText("shaders/fragment_shader.glsl")

        val vShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexCode)
        val fShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragCode)

        program = GLES20.glCreateProgram().also { prog ->
            GLES20.glAttachShader(prog, vShader)
            GLES20.glAttachShader(prog, fShader)
            GLES20.glLinkProgram(prog)
        }

        generateParticles()
        startTime = System.currentTimeMillis()
    }

    override fun onSurfaceChanged(unused: GL10?, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)

        val ratio = width.toFloat() / height.toFloat()
        // simple perspective-ish projection
        val fov = 45f
        val top = (1f * tan(Math.toRadians((fov / 2).toDouble())).toFloat())
        val bottom = -top
        val left = bottom * ratio
        val right = top * ratio
        // use a simple projection matrix via Matrix.frustumM or Matrix.perspectiveM
        Matrix.perspectiveM(projectionMatrix, 0, fov, ratio, 1f, 100f)

        // camera/view
        Matrix.setLookAtM(viewMatrix, 0,
            0f, 0f, 20f, // eye
            0f, 0f, 0f,  // center
            0f, 1f, 0f   // up
        )
    }

    override fun onDrawFrame(unused: GL10?) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        GLES20.glUseProgram(program)

        val elapsed = ((System.currentTimeMillis() - startTime) * speed) / 1000f

        // update particle transform based on touch
        if (moveOnTouch) {
            particlesPosX = -touchX * 5f
            particlesPosY = -touchY * 5f
        } else {
            particlesPosX = 0f
            particlesPosY = 0f
        }

        if (!disableRotation) {
            rotationX = sin(elapsed * 0.2f) * 0.1f
            rotationY = cos(elapsed * 0.4f) * 0.15f
            rotationZ += 0.01f * speed
        }
// Build model matrix
        val model = FloatArray(16)
        Matrix.setIdentityM(model, 0)
        Matrix.translateM(model, 0, particlesPosX, particlesPosY, 0f)
        Matrix.rotateM(model, 0, Math.toDegrees(rotationX.toDouble()).toFloat(), 1f, 0f, 0f)
        Matrix.rotateM(model, 0, Math.toDegrees(rotationY.toDouble()).toFloat(), 0f, 1f, 0f)
        Matrix.rotateM(model, 0, Math.toDegrees(rotationZ.toDouble()).toFloat(), 0f, 0f, 1f)

        // MVP = projection * view * model
        val temp = FloatArray(16)
        Matrix.multiplyMM(temp, 0, viewMatrix, 0, model, 0)
        Matrix.multiplyMM(mvpMatrix, 0, projectionMatrix, 0, temp, 0)

        val uMVP = GLES20.glGetUniformLocation(program, "uMVPMatrix")
        GLES20.glUniformMatrix4fv(uMVP, 1, false, mvpMatrix, 0)

        val uTime = GLES20.glGetUniformLocation(program, "uTime")
        val uSpread = GLES20.glGetUniformLocation(program, "uSpread")
        val uBaseSize = GLES20.glGetUniformLocation(program, "uBaseSize")
        val uSizeRandomness = GLES20.glGetUniformLocation(program, "uSizeRandomness")
        val uAlphaParticles = GLES20.glGetUniformLocation(program, "uAlphaParticles")

        GLES20.glUniform1f(uTime, elapsed)
        GLES20.glUniform1f(uSpread, particleSpread)
        GLES20.glUniform1f(uBaseSize, particleBaseSize)
        GLES20.glUniform1f(uSizeRandomness, sizeRandomness)
        GLES20.glUniform1f(uAlphaParticles, if (alphaParticles) 1f else 0f)

        setAttribute("aPosition", vertexBuffer, 3)
        setAttribute("aRandom", randomBuffer, 4)
        setAttribute("aColor", colorBuffer, 3)

        GLES20.glDrawArrays(GLES20.GL_POINTS, 0, particleCount)

        // disable arrays
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(program, "aPosition"))
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(program, "aRandom"))
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(program, "aColor"))
    }

    private fun setAttribute(name: String, buffer: FloatBuffer, size: Int) {
        val loc = GLES20.glGetAttribLocation(program, name)
        if (loc < 0) return
        buffer.position(0)
        GLES20.glEnableVertexAttribArray(loc)
        GLES20.glVertexAttribPointer(loc, size, GLES20.GL_FLOAT, false, 0, buffer)
    }

    private fun generateParticles() {
        val positions = FloatArray(particleCount * 3)
        val randoms = FloatArray(particleCount * 4)
        val colors = FloatArray(particleCount * 3)

        val palette = arrayOf(floatArrayOf(1f, 1f, 1f), floatArrayOf(1f, 1f, 1f))

        for (i in 0 until particleCount) {
            var x: Float
            var y: Float
            var z: Float
            var len: Float
            do {
                x = (Math.random() * 2 - 1).toFloat()
                y = (Math.random() * 2 - 1).toFloat()
                z = (Math.random() * 2 - 1).toFloat()
                len = x * x + y * y + z * z
            } while (len > 1f || len == 0f)

            val r = Math.cbrt(Math.random()).toFloat()
            positions[i * 3] = x * r
            positions[i * 3 + 1] = y * r
            positions[i * 3 + 2] = z * r

            for (j in 0..3) randoms[i * 4 + j] = Math.random().toFloat()

            val col = palette[(Math.random() * palette.size).toInt()]
            colors[i * 3] = col[0]
            colors[i * 3 + 1] = col[1]
            colors[i * 3 + 2] = col[2]
        }

        vertexBuffer = toFloatBuffer(positions)
        randomBuffer = toFloatBuffer(randoms)
        colorBuffer = toFloatBuffer(colors)
    }

    private fun toFloatBuffer(array: FloatArray): FloatBuffer {
        return ByteBuffer.allocateDirect(array.size * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().apply {
            put(array)
            position(0)
        }
    }

    private fun loadShader(type: Int, shaderCode: String): Int {
        val shader = GLES20.glCreateShader(type)
        GLES20.glShaderSource(shader, shaderCode)
        GLES20.glCompileShader(shader)

        val compiled = IntArray(1)
        GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0)
        if (compiled[0] == 0) {
            val info = GLES20.glGetShaderInfoLog(shader)
            GLES20.glDeleteShader(shader)
            throw RuntimeException("Could not compile shader: $info")
        }

        return shader
    }

    private fun loadAssetText(path: String): String {
        context.assets.open(path).use { stream ->
            return stream.bufferedReader().use(BufferedReader::readText)
        }
    }
}