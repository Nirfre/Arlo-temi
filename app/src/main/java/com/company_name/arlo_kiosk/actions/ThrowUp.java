package com.company_name.arlo_kiosk.actions;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;

import com.company_name.arlo_kiosk.R;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class ThrowUp {

    public ThrowUp(final Activity context, final Robot robot) {
        robot.tiltAngle(-30);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                robot.speak(TtsRequest.create("barf barf I'm not feeling very well.", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("I'll head back to my home base.", true));
                        robot.goTo("home base");
                    }
                }, 3000);
            }
        }, 3000);
    }
}
