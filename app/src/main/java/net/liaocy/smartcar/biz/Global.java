package net.liaocy.smartcar.biz;

import android.app.Application;

public class Global extends Application {
    public String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
