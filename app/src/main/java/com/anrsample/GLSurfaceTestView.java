package com.anrsample;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLSurfaceTestView extends GLSurfaceView implements GLSurfaceView.Renderer {

    public GLSurfaceTestView(Context context) {
        super(context);
        init();
    }

    public GLSurfaceTestView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setRenderer(this);
        setRenderMode(RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public synchronized void onSurfaceCreated(GL10 gl, EGLConfig config) {
    }

    @Override
    public synchronized void onSurfaceChanged(GL10 gl, int width, int height) {
    }

    @Override
    public synchronized void onDrawFrame(GL10 gl) {
        gl.glClearColor(0.5f, 1.0f, 0.0f, 1.0f);
        gl.glClear(gl.GL_COLOR_BUFFER_BIT);
    }
}
