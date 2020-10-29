package cn.jzvd;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Nathen
 * On 2016/04/04 22:13
 */
public interface OnUserAction {

    int ON_CLICK_START_ICON = 0;
    int ON_CLICK_START_ERROR = 1;
    int ON_CLICK_START_AUTO_COMPLETE = 2;

    int ON_CLICK_PAUSE = 3;
    int ON_CLICK_RESUME = 4;
    int ON_SEEK_POSITION = 5;
    int ON_AUTO_COMPLETE = 6;

    int ON_ENTER_FULLSCREEN = 7;
    int ON_QUIT_FULLSCREEN = 8;
    int ON_ENTER_TINYSCREEN = 9;
    int ON_QUIT_TINYSCREEN = 10;


    int ON_TOUCH_SCREEN_SEEK_VOLUME = 11;
    int ON_TOUCH_SCREEN_SEEK_POSITION = 12;

    int ON_CLICK_START_THUMB = 13;
    int ON_CLICK_BLANK = 14;

    @IntDef({ON_CLICK_START_ICON,ON_CLICK_START_ERROR,ON_CLICK_START_AUTO_COMPLETE,ON_CLICK_PAUSE,ON_CLICK_RESUME,
            ON_SEEK_POSITION,ON_AUTO_COMPLETE,ON_ENTER_FULLSCREEN,ON_QUIT_FULLSCREEN,ON_ENTER_TINYSCREEN,ON_QUIT_TINYSCREEN,
            ON_TOUCH_SCREEN_SEEK_VOLUME,ON_TOUCH_SCREEN_SEEK_POSITION,ON_CLICK_START_THUMB,ON_CLICK_BLANK})
    @Retention(RetentionPolicy.SOURCE)
    @interface UserAction{}
    void onEvent(@UserAction int type, Object url, int screen, Object... objects);

}
