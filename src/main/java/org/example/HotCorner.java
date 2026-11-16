package org.example;

import java.util.concurrent.*;

public class HotCorner {
    ScheduledFuture<?> incrementBrightness;
    ScheduledFuture<?> resetBrightness;
    private final ScheduledExecutorService scheduledExecutorService;
    private final Brightness brightness;
    private long startHotCorner = 0;

    public HotCorner(Brightness brightness) {
        this(new ScheduledThreadPoolExecutor(2), brightness);
    }

    public HotCorner(ScheduledExecutorService scheduledExecutorService, Brightness brightness) {
        this.scheduledExecutorService = scheduledExecutorService;
        this.brightness = brightness;
    }

    public void startHotCorner() {
        if (brightness.getBrightness() == 100) {
            return;
        }

        startHotCorner = System.currentTimeMillis();
        brightness.setResetValue();
        incrementBrightness = scheduledExecutorService.
                scheduleAtFixedRate(brightness::incrementBrightness,
                        2000,
                        500,
                        TimeUnit.MILLISECONDS);


    }

    public boolean stopHotCorner() {
        if (incrementBrightness == null) {
            // act as a single click and change page.
            return true;
        }

        long diff = System.currentTimeMillis() - startHotCorner;
        cancelIncrementBrightness();
        if (diff < 2000) {
            return true;
        } else {
            System.out.println("Schedule reset brightness thread....");
            resetBrightness();
        }
        return false;
    }

    private void resetBrightness() {
        resetBrightness = scheduledExecutorService.
                schedule(brightness::resetBrightness,
                        15000,
                        TimeUnit.MILLISECONDS);
    }

    private void cancelIncrementBrightness() {
        if (incrementBrightness != null) {
            incrementBrightness.cancel(true);
            incrementBrightness = null;
        }
    }

    private void cancelResetBrightness() {
        if (resetBrightness != null) {
            resetBrightness.cancel(true);
            resetBrightness = null;
        }
    }
}