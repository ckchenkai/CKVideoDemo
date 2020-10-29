package cn.jzvd;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface OnCurrentStateInterface {
    int CURRENT_STATE_NORMAL =100;
    int CURRENT_STATE_PREPARING = 101;
    int CURRENT_STATE_PREPARING_CHANGING_URL = 102;
    int CURRENT_STATE_PLAYING = 103;
    int CURRENT_STATE_PAUSE = 104;
    int CURRENT_STATE_AUTO_COMPLETE = 105;
    int CURRENT_STATE_ERROR = 106;

    @IntDef({CURRENT_STATE_NORMAL, CURRENT_STATE_PREPARING, CURRENT_STATE_PREPARING_CHANGING_URL, CURRENT_STATE_PLAYING,
            CURRENT_STATE_PAUSE, CURRENT_STATE_AUTO_COMPLETE, CURRENT_STATE_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    @interface State {
    }

    void onSate(@State int state);
}
