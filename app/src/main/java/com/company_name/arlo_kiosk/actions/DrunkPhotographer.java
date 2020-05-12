package com.company_name.arlo_kiosk.actions;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;

import com.company_name.arlo_kiosk.R;
import com.company_name.arlo_kiosk.activity.Camera;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class DrunkPhotographer {

    public DrunkPhotographer(final Activity context, final Robot robot) {
        robot.speak(TtsRequest.create("Outta my way, move out of my way!", true));
        context.startActivity(new Intent(context, Camera.class));
        new Thread(new Runnable() {
            @Override
            public void run() {
                float Aspeed = 1;
                int time = 1000;
                int iterations = 4;

                long t = System.currentTimeMillis();
                long end = t + time;

                for (int x = 0; x <= iterations; x++) {
                    while (System.currentTimeMillis() < end) {
                        if (x == 0)
                            continue;
                        robot.skidJoy(0.5f, Aspeed);
                    }
                    Aspeed = -Aspeed;
                    t = System.currentTimeMillis();
                    end = t + time;
                }
            }
        }).run();
    }
}
