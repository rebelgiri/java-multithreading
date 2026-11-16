package org.example;

public class FuturePlay {
    public TaskResult doTask(String name, int time) throws InterruptedException {
        System.out.println("Start: doTask() " + name);
        TaskResult taskResult = new TaskResult(name, time);
        Thread.sleep(time);
        System.out.println("Stop: doTask() " +  name);
        return taskResult;
    }
}

