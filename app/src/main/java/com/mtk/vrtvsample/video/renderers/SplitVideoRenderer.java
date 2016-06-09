package com.mtk.vrtvsample.video.renderers;

import android.content.Context;

import com.mtk.vrtvsample.objects.GLVideo;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * Created by quanhua on 06/01/2016.
 */
public class SplitVideoRenderer extends BaseVideoRenderer{

    private static final String TAG = "SplitVideoRenderer";
    private GLVideo video_left;
    private GLVideo video_right;

    public SplitVideoRenderer(Context context) {
        super(context);
    }

    private static final float OFFSET = 0.68f;

    @Override
    public void onSurfaceCreated(EGLConfig eglConfig) {
        super.onSurfaceCreated(eglConfig);

        float[] VERTEX_DATA_LEFT = {
                // X, Y, Z, U, V
                -12.8f - OFFSET, -7.2f, -10, 0.f, 0.f,
                12.8f  - OFFSET, -7.2f, -10, 0.5f, 0.f,
                -12.8f - OFFSET,  7.2f, -10, 0.f, 1.f,
                12.8f  - OFFSET,  7.2f, -10, 0.5f, 1.f,
        };
        video_left = new GLVideo(VERTEX_DATA_LEFT);

        float[] VERTEX_DATA_RIGHT = {
                // X, Y, Z, U, V
                -12.8f + OFFSET, -7.2f, -10, 0.5f, 0.f,
                12.8f  + OFFSET, -7.2f, -10, 1f, 0.f,
                -12.8f + OFFSET,  7.2f, -10, 0.5f, 1.f,
                12.8f  + OFFSET,  7.2f, -10, 1f, 1.f,
        };
        video_right = new GLVideo(VERTEX_DATA_RIGHT);
    }

    public void onDrawFrame(float[] matrix, boolean isLeft) {
        super.onDrawFrame(matrix);

        if (isLeft){
            video_left.bindData(videoShaderProgram);
            video_left.draw();
        }else{
            video_right.bindData(videoShaderProgram);
            video_right.draw();
        }
    }
}
