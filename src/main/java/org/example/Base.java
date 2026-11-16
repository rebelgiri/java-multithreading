package org.example;

public class Base {
    protected String channel;
    protected int id;

    public Base(String channel, int id){
        this.channel = channel;
        this.id = id;
    }

    public void update(){
        System.out.println("Base Class: Update");
    }

    public void support(){
        System.out.println("Base Class: Support");
    }

    public void printData(){
        System.out.println("Channel = " + channel + ", id = " + id);
    }
}
