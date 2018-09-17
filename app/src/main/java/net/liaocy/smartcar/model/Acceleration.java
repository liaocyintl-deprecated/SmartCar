package net.liaocy.smartcar.model;

public class Acceleration {

    private float x;
    private float y;
    private float z;
    private float r;

    public Acceleration(float[] sensorValues){
        this(sensorValues[0], sensorValues[1], sensorValues[2]);
    }

    public Acceleration(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = (float)Math.sqrt(x * x + y * y + z * z);
    }



    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return String.format("X:%2.2f;Y:%2.2f;Z:%2.2f;R:%2.2f;", this.x, this.y, this.z, this.r);
    }
}
