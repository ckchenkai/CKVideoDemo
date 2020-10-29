package com.example.ckvideodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import cn.jzvd.JZMediaManager;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.jzvd.OnCurrentStateInterface;

public class MainActivity extends AppCompatActivity implements OnCurrentStateInterface {
    JZVideoPlayerStandard videoPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoPlayer = findViewById(R.id.video_player);

        videoPlayer.setTopBarVisible(false, false)
                .setStartBtnVisible(false)
                .setMediaType(JZMediaManager.MediaType.SYSTEM)
                .setOnCurStateListener(this)
                .setIsHideControl(true)
                .setUp(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video), JZVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");
        videoPlayer.startPlay();
        //"android.resource://" + getPackageName() + "/" + R.raw.splash_video
    }
    @Override
    protected void onPause() {
        super.onPause();
        videoPlayer.pauseVideo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoPlayer.resumeVideo();
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onSate(int state) {
        switch (state) {
            case CURRENT_STATE_NORMAL:
            case CURRENT_STATE_PREPARING_CHANGING_URL:
            case CURRENT_STATE_PAUSE:
            case CURRENT_STATE_AUTO_COMPLETE:
                Toast.makeText(this,"播放结束",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case CURRENT_STATE_ERROR:
                break;
            case CURRENT_STATE_PREPARING:
            case CURRENT_STATE_PLAYING:
                break;

        }
    }
}