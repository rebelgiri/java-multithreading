package org.example;

import java.util.concurrent.TimeUnit;

public class SimpleRunnable extends Thread {

    @Override
    public void run(){
        System.out.printf("%s: Starting Runnable Thread\n", this.getName());
        this.interrupt();
        System.out.println("Is interrupted? " + this.isInterrupted());
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            System.out.println("Interrupted...");
        }

        System.out.printf("%s: Ending Runnable Thread\n", this.getName());

    }


    public void doSimpleTask(){
        System.out.printf("%s: Starting Runnable Thread\n", this.getName());
        //this.interrupt();
        //System.out.println("Is interrupted? " + this.isInterrupted());
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            System.out.println("Interrupted...");
        }

        System.out.printf("%s: Ending Runnable Thread\n", this.getName());

    }


    public int doSimpleTaskAndReturnConstant(){
        System.out.printf("%s: Inside Runnable Thread\n", this.getName());
        return 10;
    }

}
