package org.example;

public class Brightness {

    int brightness = 0;
    int resetValue = 0;

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setResetValue() {
        this.resetValue = this.brightness;
    }
    public void incrementBrightness() {
        this.brightness = this.brightness + 10;
        System.out.println("Incremented Brightness = " + this.brightness);
    }

    public void resetBrightness() {
        this.brightness = this.resetValue;
    }

}
