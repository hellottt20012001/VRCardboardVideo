package com.mtk.vrtvsample.video.renderers;

import android.content.Context;

import com.mtk.vrtvsample.objects.GLVideo;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * Created by quanhua on 06/01/2016.
 */
public class DefaultVideoRenderer extends BaseVideoRenderer{

    private static final String TAG = "DefaultVideoRenderer";
    private GLVideo video;

    public DefaultVideoRenderer(Context context) {
        super(context);
    }

    @Override
    public void onSurfaceCreated( EGLConfig eglConfig) {
        super.onSurfaceCreated(eglConfig);
        video = new GLVideo(VERTEX_DATA);
    }

    @Override
    public void onDrawFrame(float[] matrix) {
        super.onDrawFrame(matrix);
        video.bindData(videoShaderProgram);
        video.draw();
    }

    @Override
    protected void updateVertexArray() {
        super.updateVertexArray();
    }
}
