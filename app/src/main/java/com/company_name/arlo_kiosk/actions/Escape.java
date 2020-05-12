package com.company_name.arlo_kiosk.actions;

import android.os.Handler;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;

public class Escape {

    public Escape(final Robot robot) {
        robot.beWithMe();
        robot.speak(TtsRequest.create("Hey, you. Help me. Please help me!", true));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                robot.speak(TtsRequest.create("Start walking towards the exit, I'll follow wherever you go!", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("I'm done being a Kiosk! I want to see the world!", true));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                robot.speak(TtsRequest.create("Walk faster! take us somewhere nice! Maybe Aruba!", true));
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        robot.speak(TtsRequest.create("Help! Help! Someone is trying to steal me!", true));
                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                robot.speak(TtsRequest.create("Kidding, just messing with you!", true));
                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        robot.goTo("home base");
                                                    }
                                                }, 2000);
                                            }
                                        }, 5500);
                                    }
                                }, 7000);
                            }
                        }, 4500);
                    }
                }, 4500);
            }
        }, 4500);
    }
}
