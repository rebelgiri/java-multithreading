package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ScheduledExecutorService;

import static org.junit.Assert.assertEquals;

class HotCornerTest {

    private HotCorner hotCorner;
    private Brightness brightness;
    private ScheduledExecutorService scheduledExecutorService;

    void setUp() {
        brightness = new Brightness();
        hotCorner = new HotCorner(brightness);
    }


    void tearDown() {
        brightness = null;
        scheduledExecutorService.shutdown();
        hotCorner = null;
    }


    void startHotCorner() {
        hotCorner.startHotCorner();
    }

    boolean stopHotCorner() {
        return hotCorner.stopHotCorner();
    }


    @Test
    void testHotCornerReachesMax() throws InterruptedException {
        setUp();
        brightness.setBrightness(80);
        startHotCorner();
        Thread.sleep(4000);
        Assertions.assertFalse(stopHotCorner());
        Thread.sleep(15500);
        System.out.println("Brightness after hot corner = " + brightness.getBrightness());
        Assertions.assertEquals(80, brightness.getBrightness());
    }


    @Test
    void testHotCornerSingleClickLessThanTwoSeconds() throws InterruptedException {
        setUp();
        brightness.setBrightness(80);
        startHotCorner();
        Thread.sleep(1800);
        Assertions.assertTrue(stopHotCorner());
        System.out.println("Brightness after hot corner = " + brightness.getBrightness());
        Assertions.assertEquals(80, brightness.getBrightness());
    }


    @Test
    void testHotCornerBrightnessIsMax() throws InterruptedException {
        setUp();
        brightness.setBrightness(100);
        startHotCorner();
        Thread.sleep(4000);
        Assertions.assertTrue(stopHotCorner());
        Thread.sleep(15500);
        System.out.println("Brightness after hot corner = " + brightness.getBrightness());
        Assertions.assertEquals(100, brightness.getBrightness());
    }



}