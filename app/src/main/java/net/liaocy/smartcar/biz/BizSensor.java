package net.liaocy.smartcar.biz;

import android.app.Application;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import net.liaocy.smartcar.model.Acceleration;

import java.util.ArrayList;
import java.util.List;

public class BizSensor extends Thread implements SensorEventListener {
    private SensorManager sensorManager;
    private Acceleration currentAcceleration;
    private List<Acceleration> accelerations;

    public BizSensor(Application application) {
        this.sensorManager = (SensorManager) application.getSystemService(Context.SENSOR_SERVICE);
        this.sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        this.currentAcceleration = new Acceleration(0, 0, 0);
        this.accelerations = new ArrayList<>();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        switch (event.sensor.getType()) {
            case android.hardware.Sensor.TYPE_ACCELEROMETER:
                getAccelerometer(event);
                break;
            default:
                break;
        }
    }

    private void getAccelerometer(SensorEvent event) {
        synchronized(this.currentAcceleration){
            this.currentAcceleration = new Acceleration(event.values);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public Acceleration getCurrentAcceleration() {
        synchronized(this.currentAcceleration) {
            return this.currentAcceleration;
        }
    }

    public List<Acceleration> getAccelerations(){
        synchronized(this.accelerations) {
            return this.accelerations;
        }
    }

    @Override
    public void run() {
        while (true) {

            synchronized(this.accelerations) {
                if (this.accelerations.size() > 100) {
                    this.accelerations.remove(0);
                }
                this.accelerations.add(this.getCurrentAcceleration());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
