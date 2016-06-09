package com.mtk.vrtvsample.video.players;

import android.view.Surface;

import java.io.IOException;

/**
 * Created by quanhua on 08/01/2016.
 */
public interface BasePlayer {
    void setDataSource(String dataSource) throws IOException;

    boolean isPlaying();

    void pause();

    void start();

    void setSurface(Surface surface);

    void prepare() throws Exception;

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener);

    interface OnVideoSizeChangedListener{
        void onVideoSizeChanged(int width, int height);
    }
}
