package com.mtk.vrtvsample.programs;

import android.content.Context;
import android.opengl.GLES20;

import com.mtk.vrtvsample.utils.ShaderHelper;
import com.mtk.vrtvsample.utils.TextResourceReader;


/**
 * Created by quanhua on 05/01/2016.
 */
abstract class ShaderProgram {
    // Uniform constants
    protected static final String U_MATRIX = "u_Matrix";
    protected static final String U_TEXTURE_UNIT = "u_TextureUnit";
    protected static final String U_COLOR = "u_Color";
    protected static final String U_MVPMATRIX = "u_MVPMatrix";
    protected static final String U_STMATRIX = "u_STMatrix";

    // Attribute constants
    protected static final String A_POSITION = "a_Position";
    protected static final String A_COLOR = "a_Color";
    protected static final String A_TEXTURE_COORDINATES = "a_TextureCoordinates";

    // Shader program
    protected final int program;
    protected ShaderProgram(Context context, int vertexShaderResourceId, int fragmentShaderResourceId) {
        program = ShaderHelper.buildProgram(
                TextResourceReader.readTextFileFromResource(context, vertexShaderResourceId),
                TextResourceReader.readTextFileFromResource(context, fragmentShaderResourceId));
    }

    public void useProgram(){
        GLES20.glUseProgram(program);
    }
}
