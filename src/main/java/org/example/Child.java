package org.example;

public class Child extends Base{

    public Child(String channel, int id) {
        super(channel, id);
    }

    @Override
    public void update() {
        System.out.println("Child Updated");
        this.channel = this.channel + " is Updated";
        this.id = this.id + 10;
    }
}
