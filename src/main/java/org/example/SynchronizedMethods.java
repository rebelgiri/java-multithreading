package org.example;

public class SynchronizedMethods {

    private int sum = 0;

    public static int staticSum = 0;

    public synchronized void calculate() {
        setSum(getSum() + 1);
    }

    public void setSum(int value) {
        sum = value;
    }

    public int getSum() {
        return sum;
    }

    public static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }
}

