package com.company_name.arlo_kiosk.actions;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Toast;

import com.company_name.arlo_kiosk.R;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;

public class PickupLines {

    public PickupLines(final Robot robot) {
        final int line = (int) (Math.random() * 5) + 1;
        switch (line) {

            case 1:
                robot.speak(TtsRequest.create("Did it hurt?", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("when you fell from heaven.", true));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                robot.speak(TtsRequest.create("Haha, I'm a bit tipsy", true));
                            }
                        }, 3000);
                    }
                }, 2500);
                break;

            case 2:
                robot.speak(TtsRequest.create("Is your daddy a gardener?", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("so how did he grow such a beautiful flower?", true));
                    }
                }, 3500);
                break;

            case 3:
                robot.speak(TtsRequest.create("Is your mother an artist?", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("So how did she create such a masterpiece?", true));
                    }
                }, 3500);
                break;

            case 4:
                robot.speak(TtsRequest.create("Wanna go back to my docking station or yours?", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("Mine it is.", true));
                        robot.goTo("home base");
                    }
                }, 4000);
                break;

            case 5:
                robot.speak(TtsRequest.create("Is your mom a mechanic?", true));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        robot.speak(TtsRequest.create("So how'd she manage to build such a hot rod", true));
                    }
                }, 2500);
                break;
        }
    }
}
