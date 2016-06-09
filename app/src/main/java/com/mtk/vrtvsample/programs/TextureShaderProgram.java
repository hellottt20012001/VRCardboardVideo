package com.mtk.vrtvsample.programs;

import android.content.Context;
import android.opengl.GLES20;

import com.mtk.vrtvsample.R;


/**
 * Created by quanhua on 05/01/2016.
 */
public class TextureShaderProgram extends ShaderProgram{

    public static final int DEFAULT_VERTEX_SHADER = R.raw.default_texture_vertex_shader;
    public static final int DEFAULT_FRAGMENT_SHADER = R.raw.default_texture_fragment_shader;

    // Uniform locations
    private final int uMVPLocation;
    private final int uTextureUnitLocation;


    // Attribute locations
    private final int aPositionLocation;
    private final int aTextureCoordinatesLocation;

    public TextureShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId){
        super(context, vertexShaderResourceId, fragmentShaderResourceId);

        // Retrieve uniform locations for the shader program
        uMVPLocation = GLES20.glGetUniformLocation(program, U_MVPMATRIX);
        uTextureUnitLocation = GLES20.glGetUniformLocation(program, U_TEXTURE_UNIT);

        // Retrieve attribute locations for the shader program
        aPositionLocation = GLES20.glGetAttribLocation(program, A_POSITION);
        aTextureCoordinatesLocation = GLES20.glGetAttribLocation(program, A_TEXTURE_COORDINATES);
    }

    public void setUniforms(float[] matrix, int textureId){
        // Pass the matrix into the shader program
        GLES20.glUniformMatrix4fv(uMVPLocation, 1, false, matrix, 0);

        // Set the active texture unit to texture unit 0
        GLES20.glActiveTexture(GLES20.GL_TEXTURE0);

        // Bind the texture to this unit
        GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, textureId);

        // Tell the texture unifroam sampler to use this texture in the shader by
        // telling it to read from texture unit 0
        GLES20.glUniform1i(uTextureUnitLocation, 0);
    }

    public int getPositionAttributeLocation(){
        return aPositionLocation;
    }

    public int getTextureCoordinatesAttributeLocation(){
        return aTextureCoordinatesLocation;
    }
}
