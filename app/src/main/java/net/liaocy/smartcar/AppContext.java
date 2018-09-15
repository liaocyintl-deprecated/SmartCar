package net.liaocy.smartcar;

import android.app.Application;

import net.liaocy.smartcar.biz.Speaker;


public class AppContext extends Application {
    private static AppContext instance;

    private Speaker speaker;

    public Speaker getSpeaker(){
        return this.speaker;
    }

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;

        //init and start speaker
        speaker = new Speaker(this);
        speaker.Speak("System activated");
        //init and start speaker -- end
    }
}
