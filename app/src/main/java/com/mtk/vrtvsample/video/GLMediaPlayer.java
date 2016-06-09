package com.mtk.vrtvsample.video;

import android.content.Context;
import android.util.Log;
import android.view.Surface;

import com.mtk.vrtvsample.video.players.BasePlayer;
import com.mtk.vrtvsample.video.players.CustomExoPlayer;
import com.mtk.vrtvsample.video.renderers.BaseVideoRenderer;
import com.mtk.vrtvsample.video.renderers.DefaultVideoRenderer;

import java.io.IOException;

/**
 * Created by quanhua on 06/01/2016.
 */
public class GLMediaPlayer {
    private final static String TAG = "GLMediaPlayer";
    private CustomExoPlayer mediaPlayer = null;
    private Context context = null;

    //=================== + Constructors + ===================
    public GLMediaPlayer(Context context) {
        this(context, false);
    }
    public GLMediaPlayer(Context context, boolean useExoPlayer) {
        this(context, new DefaultVideoRenderer(context), useExoPlayer);
    }

    public GLMediaPlayer(Context context, BaseVideoRenderer renderer, boolean useExoPlayer) {
        if(renderer == null) {
            Log.e(TAG, "Renderer is null");
            return;
        }
        if(useExoPlayer){
            this.mediaPlayer = new CustomExoPlayer(context);
        }/*else{
            this.mediaPlayer = new AndroidPlayer();
        }*/

        this.context = context;
        renderer.setGlMediaPlayer(this);
    }

    //=================== + Getter + ===================

    //=================== + Setter + ===================
    public void setDataSource(String dataSource) {
        if (mediaPlayer != null){
            try {
                mediaPlayer.setDataSource(dataSource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Log.e(TAG, "setDataSource: mediaPlayer == null");
        }
    }

    public void pause(){
        Log.d(TAG, "pause()");


        //if(mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        //}
    }

    public void resume(){
        Log.d(TAG, "resume()");

        // TODO: Resume player

        this.mediaPlayer.start();
    }

    public void setSurface(Surface surface) {
        this.mediaPlayer.setSurface(surface);
    }

    public void prepare() {
        try{
            this.mediaPlayer.prepare();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start() {
        try{
            this.mediaPlayer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setOnVideoSizeChangedListener(BasePlayer.OnVideoSizeChangedListener listener){
        this.mediaPlayer.setOnVideoSizeChangedListener(listener);
    }
}
