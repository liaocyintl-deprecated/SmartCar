package net.liaocy.smartcar;

import android.app.Application;

import net.liaocy.smartcar.biz.BizSensor;
import net.liaocy.smartcar.biz.BizSpeaker;


public class AppContext extends Application {
    private static AppContext instance;

    private BizSpeaker bizSpeaker;

    private BizSensor bizSensor;

    public BizSpeaker getBizSpeaker() {
        return this.bizSpeaker;
    }

    public BizSensor getBizSensor() {
        return this.bizSensor;
    }

    public static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        instance = this;

        //init and start bizSpeaker
        bizSpeaker = new BizSpeaker(this);
        //init and start bizSpeaker -- end

        //init and start sensor monitors
        this.bizSensor = new BizSensor(this);
        this.bizSensor.start();
        //init and start sensor monitors -- end
    }
}
