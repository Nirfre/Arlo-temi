package com.company_name.arlo_kiosk.actions;

import android.app.Activity;
import android.media.MediaPlayer;

import com.company_name.arlo_kiosk.R;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

import android.os.Handler;

public class DancingRobot {

    private Robot robot;

    public DancingRobot(final Activity context, final Robot robot) {
        this.robot = robot;
        robot.speak(TtsRequest.create("Outta my way, move out of my way!",true));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                robot.speak(TtsRequest.create("I'm gonna burn this dance floor",true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        MediaPlayer dancePlayer = MediaPlayer.create(context, R.raw.dance);
                        dancePlayer.start();
                        dancePlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                robot.speak(TtsRequest.create("Never mind I’m wasted. I'll go rest a bit.", true));
                                robot.goTo("home base");
                            }
                        });
                        firstDance();
                    }
                },4000);
            }
        },3000);
    }

    private void firstDance() {
        long t = System.currentTimeMillis();
        int time = 700;
        int time2 = 5000;
        long end = t + time;
        long end2;

        int x = 0;
        int tiltSwitch = 1000;
        int tiltAngle = 30;

        while (System.currentTimeMillis() < end) {
            if (x>= tiltSwitch){
                x = 0;
                tiltAngle = -tiltAngle;
            }
            robot.skidJoy(1, 0);
            robot.tiltAngle(tiltAngle, 10f);
            ++x;

        }
        x = 0;
        t = System.currentTimeMillis();
        end2 = t + time2;

        while (System.currentTimeMillis() < end2) {
            if (x>= tiltSwitch){
                x = 0;
                tiltAngle = -tiltAngle;
            }
            robot.skidJoy(0, 1);
            robot.tiltAngle(tiltAngle, 10f);
            ++x;

        }

        x = 0;
        t = System.currentTimeMillis();
        end2 = t + 5000;
        while (System.currentTimeMillis() < end2) {
            if (x>= tiltSwitch){
                x = 0;
                tiltAngle = -tiltAngle;
            }
            robot.skidJoy(0, -1);
            robot.tiltAngle(tiltAngle, 10f);
            ++x;

        }
    }
}
