package com.ali_sajjadi.test.homeBackground

import android.content.Context
import android.view.MotionEvent
import android.opengl.GLSurfaceView

class ParticleGLSurfaceView(context: Context) : GLSurfaceView(context) {
    private val renderer: ParticlesRenderer

    init {
        setEGLContextClientVersion(2)
        renderer = ParticlesRenderer(context)
        setRenderer(renderer)
        renderMode = RENDERMODE_CONTINUOUSLY
    }

    fun enableTouchMovement(enabled: Boolean) {
        renderer.setMoveOnTouch(enabled)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_MOVE, MotionEvent.ACTION_DOWN -> {
                val x = (event.x / width) * 2f - 1f
                val y = -((event.y / height) * 2f - 1f)
                renderer.setTouchNormalized(x, y)
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                // optionally reset
                renderer.setTouchNormalized(0f, 0f)
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}