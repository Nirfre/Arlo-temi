package com.company_name.arlo_kiosk.actions;

import android.app.Activity;
import android.os.Handler;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class Prankster {

    public Prankster(final Activity context, final Robot robot) {
        robot.tiltAngle(-30);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                robot.speak(TtsRequest.create("Your shoe is untied.", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.tiltAngle(30);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                robot.speak(TtsRequest.create("Baahahaha! made you look", true));
                            }
                        }, 2250);
                    }
                }, 1000);
            }
        }, 2500);
    }
}
