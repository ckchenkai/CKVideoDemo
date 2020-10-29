# CKVideoDemo
## 基于ijkplayer封装的视频播放器，支持绝大多数视频格式，可列表播放、支持直播流

### 注意：目前 module 里仅支持了 armv7 的 ijkpalyer 的 so 包，所以需要在 app.gradle 文件 defaultConfig 下加入以下代码：

```groovy
ndk {
 	abiFilters "armeabi-v7a"  
 }
```
1.直接播放视频
 
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash_video);
        //播放Uri时，必须setMediaType为JZMediaManager.MediaType.SYSTEM
        videoPlayer.setTopBarVisible(false, false)
                .setStartBtnVisible(false) //开始播放按钮是否显示
                .setMediaType(JZMediaManager.MediaType.IJKPLAYER) //原生MediaPlayer还是IjkPlayer的内核(默认IjkPlayer)
                .setOnCurStateListener(this) //播放状态回调
                .setIsHideControl(true) //是否隐藏所有控制面板，只展示视频
                .setIsLiveStream(false)//是否直播流
                .setUserActionListener(this)//用户按钮点击、交互等回调
                .setUp(uri, JZVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");
        videoPlayer.startPlay();
