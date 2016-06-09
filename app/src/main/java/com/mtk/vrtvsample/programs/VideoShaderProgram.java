package com.mtk.vrtvsample.programs;

import android.content.Context;
import android.opengl.GLES20;

import com.mtk.vrtvsample.R;


/**
 * Created by quanhua on 06/01/2016.
 */
public class VideoShaderProgram extends ShaderProgram {

    public static final int DEFAULT_VERTEX_SHADER = R.raw.default_video_vertex_shader;
    public static final int DEFAULT_FRAGMENT_SHADER = R.raw.default_video_fragment_shader;

    // Uniform locations
    private int uMVPMatrixLocation;
    private int uSTMatrixLocation;

    // Attribute locations
    private int aPositionLocation;
    private int aTextureCoordinatesLocation;

    public VideoShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        super(context, vertexShaderResourceId, fragmentShaderResourceId);

        aPositionLocation = GLES20.glGetAttribLocation(program, A_POSITION);
        aTextureCoordinatesLocation = GLES20.glGetAttribLocation(program, A_TEXTURE_COORDINATES);

        uMVPMatrixLocation = GLES20.glGetUniformLocation(program, U_MVPMATRIX);
        uSTMatrixLocation = GLES20.glGetUniformLocation(program, U_STMATRIX);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }

    public int getTextureCoordinatesAttributeLocation() {
        return aTextureCoordinatesLocation;
    }
    public void setUniforms(float[] mvpMatrix, float[] stMatrix){
        GLES20.glUniformMatrix4fv(uMVPMatrixLocation, 1, false, mvpMatrix, 0 );
        GLES20.glUniformMatrix4fv(uSTMatrixLocation, 1, false, stMatrix, 0 );
    }
}
